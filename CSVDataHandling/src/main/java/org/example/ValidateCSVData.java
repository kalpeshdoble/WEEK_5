package org.example;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\Rgex.csv"; // Path to the CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // Regex pattern for validating email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Regex pattern for validating phone number (exactly 10 digits)
        String phoneRegex = "^\\d{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header (if present)
            String header = br.readLine();
            System.out.println("Processing CSV Data:");

            // Read each line (representing a record)
            while ((line = br.readLine()) != null) {
                String[] record = line.split(csvSplitBy);

                // Assuming the columns are:
                // 0: ID, 1: Name, 2: Email, 3: Phone, 4: Department, 5: Salary

                // Validate the Email field (column 2)
                String email = record[2];
                Matcher emailMatcher = emailPattern.matcher(email);
                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email in row: " + line + " -> Error: Invalid email format");
                }

                // Validate the Phone Number field (column 3)
                String phoneNumber = record[3];
                Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number in row: " + line + " -> Error: Phone number should be exactly 10 digits");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

