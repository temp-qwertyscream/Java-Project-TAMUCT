/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;
import java.util.Scanner;
/**
 * James Wiggins
 * Project
 * This is the mainline code for the Project: Student Management System
 */
public class Project {

    public static void main(String[] args) {
       StudentManagementSystem sms = new StudentManagementSystem();
       Scanner scanner = new Scanner(System.in);
       int choice = 0;
       
       do
       {
           // Main menu
           System.out.println("\nStudent Management System");
           System.out.println("1. Add New Student");
           System.out.println("2. Update Student / Add Subject Grade");
           System.out.println("3. Remove Student");
           System.out.println("4. View All Students");
           System.out.println("5. Generate Performance Report");
           System.out.println("6. Save & Exit");
           System.out.print("Please select an option (1-6): ");
           
           // Input validation
           try
           {
                choice = Integer.parseInt(scanner.nextLine().trim());
           } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number between"
                        + " 1 and 6.");
                continue;
           }
           
           switch(choice) // Menu selection
           {
               case 1: // Add New Student
                   System.out.print("Enter Student ID: ");
                   String id = scanner.nextLine().trim();
                   System.out.print("Enter Student Name: ");
                   String name = scanner.nextLine().trim();
                   
                   if(id.isEmpty() || name.isEmpty())
                       System.out.println("\nError: ID and Name cannot be empty");
                   else sms.addStudent(new Student(id, name));
                   break;
                   
               case 2: // Update Student / Add Subject Grade
                   System.out.print("Enter Student ID to update: ");
                   String updateID = scanner.nextLine().trim();
                   Student student = sms.findStudent(updateID);
                   
                   if(student != null)
                   {
                       System.out.print("Enter Subject Name: ");
                       String subName = scanner.nextLine().trim();
                       if(subName.isEmpty())
                       {
                           System.out.println("\nError: "
                                   + "Subject name cannot be empty");
                           break;
                       }
                       
                       System.out.print("Enter Grade (0-100): ");
                       try
                       {
                           double grade = Double.parseDouble(
                                   scanner.nextLine().trim());
                           student.addOrUpdateSubject(subName, grade);
                           System.out.println("\nGrade recorded successfully");
                       } catch(NumberFormatException e)
                       {
                           System.out.println("\nError: Please enter a valid "
                                   + "numeric grade");
                       } catch(IllegalArgumentException e)
                       {
                           System.out.println("\nError: " + e.getMessage());
                       }
                   } else System.out.println("\nStudent with ID '" + updateID
                   + "' not found");
                   break;
               case 3: // Remove Student
                   System.out.print("Enter Student ID to remove: ");
                   String removeId = scanner.nextLine().trim();
                   if(sms.removeStudent(removeId)) System.out.println("\nStudent "
                           + "removed successfully");
                   else System.out.println("\nStudent with ID '" + removeId 
                           + "' not found.");
                   break;
               case 4: // View All Students
                   sms.displayAllStudents();
                   break;
               case 5: // Generate Performance Report
                   sms.generateReport();
                   break;
               case 6: // Save & Exit
                   sms.saveToFile();
                   System.out.println("Closing menu...");
                   break;
               default: // Invalid input
                   System.out.println("\nInvalid option. Please choose 1-6");     
           }
       } while(choice != 6);
       scanner.close();
    }
}
