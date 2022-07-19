package com.udemy.java;

import com.udemy.java.compare.Student;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StudentTest {

    public static void main(String[] args) {

        Student a = new Student("Ritu",112,156);
        Student b = new Student("Shweta",132,151);
        Student c = new Student("Shruti",128,166);

        Optional<Student> student = Stream.of(a, b, c)
                .min(Comparator.comparing(Student::getScore));

        System.out.println(student.get());


    }
}
