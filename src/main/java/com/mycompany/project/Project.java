/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;

/**
 *
 * @author James
 */
public class Project {

    public static void main(String[] args) {
        // Creating a student
        Student student = new Student("S101", "John Doe");
        Student student1 = new Student("S102", "Jane Doe");
        
        // Adding Subjects with grades to a student
        student.addSubject("Math", 88.5);
        student.addSubject("Science", 95.0);
        student1.addSubject("History", 65.6);
        student1.addSubject("Math", 75.3);
        
        // Verification
        System.out.println(student);
        System.out.println("Courses: " + student.getSubjects());
        System.out.println("\n" + student1);
        System.out.println("Courses: " + student1.getSubjects());
    }
}
