/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.io.Serializable;
/**
 * James Wiggins
 * Subject
 * This is the class for subject, to identify
 * the course and grade of a student. Includes validation and structure for file 
 * saving.
 */
public class Subject implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;     // Course
    private double grade;   // Student Grade
    
    // Constructor
    public Subject(String name, double grade) {
        this.name = name;
        setGrade(grade);        // Enforcing Validation
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
    public void setGrade(double grade)  // Validation
    {
        if (grade < 0.0 || grade > 100.0)
        {
            throw new IllegalArgumentException("\nGrade must be between 0 and 100");
        }            
        this.grade = grade;
    }
    
    // Error Handling for naming structure
    @Override
    public String toString() {
        return name + ": " + grade;
    }
}
