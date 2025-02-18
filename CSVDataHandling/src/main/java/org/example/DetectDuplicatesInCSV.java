package org.example;

import java.io.*;
import java.util.*;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\student1.csv"; // Path to the CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // Set to store unique IDs
        Set<Integer> seenIds = new HashSet<>();

        // List to store duplicate records
        List<String> duplicateRecords = new ArrayList<>();

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); // Read and ignore the header line

            // Read each line (representing a record)
            while ((line = br.readLine()) != null) {
                String[] record = line.split(csvSplitBy);

                // Assuming ID is in the first column
                int id = Integer.parseInt(record[0]);

                // Check if the ID has already been seen
                if (seenIds.contains(id)) {
                    // If it's a duplicate, add to the duplicate list
                    duplicateRecords.add(line);
                } else {
                    // Otherwise, add the ID to the seen set
                    seenIds.add(id);
                }
            }

            // Print the duplicates if any
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Duplicate records found:");
                for (String duplicate : duplicateRecords) {
                    System.out.println(duplicate);
                }
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
