/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 * James Wiggins
 * Subject
 * This is the class for subject, to identify
 * the course and grade of a student.
 *
 */
public class Subject {
    private String name;     // Course
    private double grade;   // Student Grade
    
    // Constructor
    public Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    
    // Get-Set
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getGrade()
    {
        return grade;
    }
    public void setGrade(double grade)
    {
        this.grade = grade;
    }
    
    // Error Handling for naming structure
    @Override
    public String toString() {
        return name + ": " + grade;
    }
}
