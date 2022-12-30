package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorMappingExample {
    public static void main(String[] args) {
        //map
        List<String> namesList = Instructors.getAll().stream()
                .map(Instructor::getName)
                .collect(Collectors.toList());
        namesList.forEach(System.out::println);

        //mapping
        namesList= Instructors.getAll().stream()
                .collect(Collectors.mapping(Instructor::getName, Collectors.toList()));

        namesList.forEach(System.out::println);

        //Instructors by their years of experience
        System.out.println("-----------------------------");
        System.out.println(Instructors.getAll());
        Map<Integer, List<String>> mapYearsOfExperienceAndNames = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName, Collectors.toList())));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience, Collectors.toList()));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience));
        mapYearsOfExperienceAndNames.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });
        System.out.println("-----------------------------");

        mapYearsOfExperienceAndNames1.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });
        System.out.println("-----------------------------");

        mapYearsOfExperienceAndNames2.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });


/*
-Output
Mike
Jenny
Gene
Anthony
Syed
Mike
Jenny
Gene
Anthony
Syed
-----------------------------
[Instructor{name='Mike', yearsOfExperience=10, title='Software Developer', gender='M', onlineCourses=true, courses=[Java Programming, C++ Programming, Python Programming]}, Instructor{name='Jenny', yearsOfExperience=5, title='Engineer', gender='F', onlineCourses=false, courses=[Multi-Threaded Programming, CI/CD, Unit Testing]}, Instructor{name='Gene', yearsOfExperience=6, title='Manager', gender='M', onlineCourses=false, courses=[C++ Programming, C Programming, React Native]}, Instructor{name='Anthony', yearsOfExperience=15, title='Senior Developer', gender='M', onlineCourses=true, courses=[Java Programming, Angular Programming, React Native]}, Instructor{name='Syed', yearsOfExperience=15, title='Principal Engineer', gender='M', onlineCourses=true, courses=[Java Programming, Java Multi-Threaded Programming, React Native]}]
key = 5 value = [Jenny]
key = 6 value = [Gene]
key = 10 value = [Mike]
key = 15 value = [Anthony, Syed]
-----------------------------
key = 5 value = [Instructor{name='Jenny', yearsOfExperience=5, title='Engineer', gender='F', onlineCourses=false, courses=[Multi-Threaded Programming, CI/CD, Unit Testing]}]
key = 6 value = [Instructor{name='Gene', yearsOfExperience=6, title='Manager', gender='M', onlineCourses=false, courses=[C++ Programming, C Programming, React Native]}]
key = 10 value = [Instructor{name='Mike', yearsOfExperience=10, title='Software Developer', gender='M', onlineCourses=true, courses=[Java Programming, C++ Programming, Python Programming]}]
key = 15 value = [Instructor{name='Anthony', yearsOfExperience=15, title='Senior Developer', gender='M', onlineCourses=true, courses=[Java Programming, Angular Programming, React Native]}, Instructor{name='Syed', yearsOfExperience=15, title='Principal Engineer', gender='M', onlineCourses=true, courses=[Java Programming, Java Multi-Threaded Programming, React Native]}]
-----------------------------
key = 5 value = [Instructor{name='Jenny', yearsOfExperience=5, title='Engineer', gender='F', onlineCourses=false, courses=[Multi-Threaded Programming, CI/CD, Unit Testing]}]
key = 6 value = [Instructor{name='Gene', yearsOfExperience=6, title='Manager', gender='M', onlineCourses=false, courses=[C++ Programming, C Programming, React Native]}]
key = 10 value = [Instructor{name='Mike', yearsOfExperience=10, title='Software Developer', gender='M', onlineCourses=true, courses=[Java Programming, C++ Programming, Python Programming]}]
key = 15 value = [Instructor{name='Anthony', yearsOfExperience=15, title='Senior Developer', gender='M', onlineCourses=true, courses=[Java Programming, Angular Programming, React Native]}, Instructor{name='Syed', yearsOfExperience=15, title='Principal Engineer', gender='M', onlineCourses=true, courses=[Java Programming, Java Multi-Threaded Programming, React Native]}]


*/




    }
}
