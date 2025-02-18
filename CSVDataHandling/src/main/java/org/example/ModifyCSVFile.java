package org.example;

import java.io.*;
import java.util.*;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String inputCsvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\employees.csv"; // Path to the original CSV file
        String outputCsvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\updated_employees.csv"; // Path to the new CSV file with updated records
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // List to hold updated employee records
        List<String[]> updatedRecords = new ArrayList<>();

        // Try-with-resources to read the original CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsvFile))) {
            // Read the header and add it to the updated records
            String header = br.readLine();
            updatedRecords.add(header.split(csvSplitBy));

            // Process each line (employee record)
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);

                // Check if the employee is from the "IT" department
                if (employee[2].equalsIgnoreCase("IT")) {
                    // Get the current salary and increase it by 10%
                    double currentSalary = Double.parseDouble(employee[3]);
                    double newSalary = currentSalary * 1.10; // Increase salary by 10%
                    employee[3] = String.format("%.2f", newSalary); // Update the salary in the record
                }

                // Add the (possibly modified) employee record to the updated records list
                updatedRecords.add(employee);
            }

            // Now, write the updated records to a new CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCsvFile))) {
                // Write each record (header and modified records) to the new file
                for (String[] record : updatedRecords) {
                    bw.write(String.join(csvSplitBy, record)); // Join the fields with a comma
                    bw.newLine(); // Write a new line after each record
                }
            }

            System.out.println("CSV file has been updated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
