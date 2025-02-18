package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\student.csv"; // Specify the path to your CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header line (if present)
            String header = br.readLine();
            System.out.println("Student Details:");

            // Read each line (representing a student record)
            while ((line = br.readLine()) != null) {
                // Split the line into individual fields based on the CSV delimiter
                String[] student = line.split(csvSplitBy);

                // Print student details in a structured format
                System.out.println("ID: " + student[0]);
                System.out.println("Name: " + student[1]);
                System.out.println("Age: " + student[2]);
                System.out.println("Marks: " + student[3]);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

