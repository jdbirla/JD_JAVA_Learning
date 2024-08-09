package com.jd.reflection.methods.polymorphism;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingFramework {
    public void runTestSuite(Class<?> testClass) throws Throwable {
        Method[] methods = testClass.getMethods();

        Method beforeClassMethod = findMethodByName(methods, "beforeClass");

        if (beforeClassMethod != null) {
            beforeClassMethod.invoke(null);
        }

        Method beforeEachTestMethod = findMethodByName(methods, "setupTest");

        List<Method> testMethods = findMethodsByPrefix(methods, "test");

        for (Method test: testMethods) {
            Object testObject  = testClass.getDeclaredConstructor().newInstance();

            if (beforeEachTestMethod != null) {
                beforeEachTestMethod.invoke(testObject);
            }

            test.invoke(testObject);
        }

        Method afterClassMethod = findMethodByName(methods, "afterClass");
        if (afterClassMethod != null) {
            afterClassMethod.invoke(null);
        }
    }

    private Method findMethodByName(Method[] methods, String name) {
        for (Method method : methods) {
            if (method.getName().equals(name)
                    && method.getParameterCount() == 0
                    &&  method.getReturnType() == void.class) {

                return method;
            }
        }
        return null;
    }

    private List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
        List<Method> matchedMethods = new ArrayList<>();

        for (Method method : methods){
            if (method.getName().startsWith(prefix)
                    && method.getParameterCount() == 0
                    &&  method.getReturnType() == void.class) {

                matchedMethods.add(method);
            }
        }
        return matchedMethods;
    }
}
