package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\student.csv"; // Path to the CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header (if present)
            String header = br.readLine();
            System.out.println("Filtered Students (Marks > 80):");

            // Read each line (representing a student record)
            while ((line = br.readLine()) != null) {
                // Split the line into individual fields based on the delimiter
                String[] student = line.split(csvSplitBy);

                // Check if the student marks are greater than 80
                int marks = Integer.parseInt(student[3]); // Marks are in the 4th column

                if (marks > 80) {
                    // Print student details if marks > 80
                    System.out.println("ID: " + student[0]);
                    System.out.println("Name: " + student[1]);
                    System.out.println("Age: " + student[2]);
                    System.out.println("Marks: " + student[3]);
                    System.out.println("------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

