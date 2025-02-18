package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsInCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\Backup\\CSVDataHandling\\src\\main\\java\\org\\example\\employees.csv"; // Path to the CSV file
        String line;
        int rowCount = 0; // Variable to store the count of records (excluding header)

        // Try-with-resources to ensure the reader is closed after use
        try  {
            // Skip the header line
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String header = br.readLine();


            // Read each subsequent line (representing a record)
            while ((line = br.readLine()) != null) {
                rowCount++; // Count each record (excluding header)
            }

            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

