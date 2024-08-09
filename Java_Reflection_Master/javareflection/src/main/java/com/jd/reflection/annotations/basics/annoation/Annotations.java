package com.jd.reflection.annotations.basics.annoation;

import java.lang.annotation.*;

public class Annotations {
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Input {
        String value();
    }
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Operation {
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DependsOn {
        String value();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FinalResult {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ScheduledExecutorClass {
    }

    @Repeatable(ExecutionSchedules.class)
    @Target(ElementType.METHOD)
    public @interface ExecuteOnSchedule {
        int delaySeconds() default 0;

        int periodSeconds();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExecutionSchedules {
        ExecuteOnSchedule[] value();
    }
}
