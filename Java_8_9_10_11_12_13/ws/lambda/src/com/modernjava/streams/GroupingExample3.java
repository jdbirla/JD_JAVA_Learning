package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample3 {
    public static void main(String[] args) {
        //grouping by length of string and also checking that the names contains e
        //and only return those name which has e in it
        List<String> name = List.of("Sid", "Mike", "Jenny", "Gene", "Rajeev");
        LinkedHashMap<Integer, List<String>> result = name.stream()
                .collect(Collectors.groupingBy(String::length, LinkedHashMap::new, Collectors
                        .filtering(s-> s.contains("e"),Collectors.toList())));

        System.out.println("result = " + result);
        System.out.println("------------------");

        //instructor grouping them by Senior(>10) and Junior(<10) and filter them
        //on online courses
        LinkedHashMap<String, List<Instructor>> instructorByExpAndOnline = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(instructor ->
                        instructor.getYearsOfExperience()>10 ? "SENIOR": "JUNIOR",
                        LinkedHashMap::new, Collectors.filtering(s->s.isOnlineCourses(),
                                Collectors.toList())));

        instructorByExpAndOnline.forEach((key, value) -> {
            System.out.println("key  = " + key + " value = " + value);
        });
    }
}


//result = {3=[], 4=[Mike, Gene], 5=[Jenny], 6=[Rajeev]}
//------------------
//key  = JUNIOR value = [Instructor{name='Mike', yearsOfExperience=10, title='Software Developer', gender='M', onlineCourses=true, courses=[Java Programming, C++ Programming, Python Programming]}]
//key  = SENIOR value = [Instructor{name='Anthony', yearsOfExperience=15, title='Senior Developer', gender='M', onlineCourses=true, courses=[Java Programming, Angular Programming, React Native]}, Instructor{name='Syed', yearsOfExperience=15, title='Principal Engineer', gender='M', onlineCourses=true, courses=[Java Programming, Java Multi-Threaded Programming, React Native]}]

