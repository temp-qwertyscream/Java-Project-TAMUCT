/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * James Wiggins
 * StudentManagementSystem
 * This is the code for the student management system
 */
public class StudentManagementSystem {
    private List<Student> students;
    private final String fileName = "students_data.dat";
    
    // Construct
    public StudentManagementSystem()
    {
        this.students = new ArrayList<>();
        loadFromFile();     // Auto restores files at startup
    }
    
    // Add student if ID does not exist
    public boolean addStudent(Student student)
    {
        if (findStudent(student.getId()) != null)
        {
            System.out.println("\nError: A student with ID '" + student.getId() + 
                    "' already exists.");
            return false;
        }
        students.add(student);
        System.out.println("\nStudent added successfully.");
        return true;
    }
    
    // Remove student matching the ID
    public boolean removeStudent(String id)
    {
        return students.removeIf(s -> s.getId().equalsIgnoreCase(id.trim()));
    }
    
    // Searches for student by ID
    public Student findStudent(String id)
    {
        for(Student s : students)
        {
            if(s.getId().equalsIgnoreCase(id.trim())) return s;
        }
        return null;
    }
    
    // Prints all stored student records to console
    public void displayAllStudents()
    {
        if(students.isEmpty())
        {
            System.out.println("\nNo student records found.");
            return;
        }
        System.out.println("\nStudent Records");
        for(Student s : students)
        {
            System.out.println(s);
        }
    }
    
    // Calculates/Displays Class-wide stats from highest to lowest performers
    public void generateReport()
    {
        if(students.isEmpty())
        {
            System.out.println("\nNo data to generate report.");
            return;
        }
        
        double totalAverage = 0;
        for(Student s : students)
        {
            totalAverage += s.calculateAverage();
        }
        totalAverage /= students.size();
        
        Student highest = students.stream()
                .max(Comparator.comparingDouble(Student::calculateAverage))
                .orElse(null);
        Student lowest = students.stream()
                .min(Comparator.comparingDouble(Student::calculateAverage))
                .orElse(null);
        
        System.out.println("\nClass Performance Report");
        System.out.printf("Total Students: %d%n", students.size());
        System.out.printf("Overall Average: %.2f%n", totalAverage);
        if (highest != null) {
            System.out.printf("Highest Performer: %s (ID: %s) - Avg: %.2f%n",
                highest.getName(), highest.getId(), highest.calculateAverage());
        }
        if (lowest != null) {
            System.out.printf("Lowest Performer: %s (ID: %s) - Avg: %.2f%n",
                lowest.getName(), lowest.getId(), lowest.calculateAverage());
        }
    }
    
    // Save student list to local file for storage
    public void saveToFile() {
        try (ObjectOutputStream outStream = new ObjectOutputStream
        (new FileOutputStream(fileName))) {
            outStream.writeObject(students);
            System.out.println("\nData successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("\nFile Error: Could not save student data. "
                    + e.getMessage());
        }
    }
    
    // Loads file of student data if it exists
    @SuppressWarnings("unchecked")
    public void loadFromFile()
    {
        File file = new File(fileName);
        if(!file.exists()) return;  // If file doesnt exist (first run)
        
        try (ObjectInputStream inStream = new ObjectInputStream
        (new FileInputStream(fileName))) {
            students = (List<Student>) inStream.readObject();
            System.out.println("\nLoaded " + students.size() + " existing student"
                    + " record(s).");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("\nFile Error: Could not load previous data. "
                    + "Starting fresh. (" + e.getMessage() + ")");
        }
    }
}
