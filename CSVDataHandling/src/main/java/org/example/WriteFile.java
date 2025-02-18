package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\employees.csv"; // Path to the CSV file

        // Employee data to be written to the CSV file
        String[] employeeData = {
                "ID,Name,Department,Salary",  // CSV header
                "101,John Doe,Engineering,75000",
                "102,Jane Smith,Marketing,68000",
                "103,Sam Wilson,HR,72000",
                "104,Lisa Ray,Finance,82000",
                "105,Tom Harris,Engineering,76000"
        };

        // Try-with-resources to ensure the writer is closed after use
        try {
            // Write each record to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            for (String record : employeeData) {
                writer.write(record);
                writer.newLine(); // Add a new line after each record

            }
            writer.close();

            System.out.println("Employee details have been written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

