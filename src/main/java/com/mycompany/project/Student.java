/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.ArrayList;
import java.util.List;
/**
 * James Wiggins
 * Student
 * This is the class Student for identification of
 * any student using their ID, name, and subject they're taking
 */
public class Student {
    private String id;      // ID
    private String name;    // Name
    private List<Subject> subjects;     // Subject (from subject class)
    
    // Constructor
    public Student(String id, String name)
    {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }
    
    // Get-Set
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public List<Subject> getSubjects()
    {
        return subjects;
    }
    
    // add/update grade
    public void addSubject(String subjectName, double grade)
    {
        for (Subject s : subjects) 
        {
            if (s.getName().equalsIgnoreCase(subjectName))
            {
                s.setGrade(grade);
                return;
            }
        }
        subjects.add(new Subject(subjectName, grade));
    }
    
    // Calc specific student average
    public double calculateAverage()
    {
        if(subjects.isEmpty()) return 0.0;
        double sum = 0;
        for(Subject s : subjects)
        {
            sum += s.getGrade();
        }
        return sum / subjects.size();
    }
    
    // Error Handling for classification structure
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + 
                " | Avg: " + String.format("%.2f", calculateAverage());
    }
}
