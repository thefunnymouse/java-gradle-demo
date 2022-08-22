package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        System.out.println("==================================================");

        List<Student> students = loadStudent1();
//        List<Student> students = loadStudent2();
        System.out.println("Number of students: " + students.size());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        int studentId = scanner.nextInt();

        Student student = findStudent(students, studentId);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            System.out.println("Student info: " + student);
        }

        System.out.println("==================================================");
    }

    private static Student findStudent(List<Student> students, int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    /**
     * Trường hợp JSON có dạng như student1.json
     */
    private static List<Student> loadStudent1() throws IOException {
        Students students = OBJECT_MAPPER.readValue(new File("student1.json"), Students.class);
        return students.getStudents();
    }

    /**
     * Trường hợp JSON có dạng như student2.json
     */
    private static List<Student> loadStudent2() throws IOException {
        Student[] students = OBJECT_MAPPER.readValue(new File("student2.json"), Student[].class);
        return Arrays.asList(students);
    }
}
