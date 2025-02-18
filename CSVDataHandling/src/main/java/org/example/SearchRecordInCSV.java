package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecordInCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\employees.csv"; // Path to the CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)
        String searchName = "John Doe"; // Employee name to search for

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header (if present)
            String header = br.readLine();

            // Flag to check if the employee is found
            boolean found = false;

            // Read each line (representing an employee record)
            while ((line = br.readLine()) != null) {
                // Split the line into individual fields based on the delimiter
                String[] employee = line.split(csvSplitBy);

                // Check if the employee name matches the search name
                if (employee[1].equalsIgnoreCase(searchName)) {
                    // Print the department and salary
                    System.out.println("Employee Found!");
                    System.out.println("Name: " + employee[1]);
                    System.out.println("Department: " + employee[2]);
                    System.out.println("Salary: " + employee[3]);
                    found = true;
                    break; // Stop searching after finding the employee
                }
            }

            // If no record is found
            if (!found) {
                System.out.println("Employee with the name '" + searchName + "' not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

