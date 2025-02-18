package org.example;

import java.io.*;

public class ReadLargeCSVInChunks {
    public static void main(String[] args) {
        String csvFile = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\largeFile.csv"; // Path to your large CSV file
        int chunkSize = 100;  // Process 100 lines at a time
        String line;
        int totalProcessed = 0;

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int chunkCount = 0;
            while ((line = br.readLine()) != null) {
                chunkCount++;
                totalProcessed++;

                // Process the line (for example, print it)
                // In your case, you can replace this with your own processing logic
                // System.out.println(line); // Example processing

                // When we've read the chunk size, report and reset
                if (chunkCount == chunkSize) {
                    System.out.println("Processed " + totalProcessed + " records so far.");
                    chunkCount = 0;  // Reset chunk counter
                }
            }

            // Print total processed records if there are remaining lines
            if (chunkCount > 0) {
                System.out.println("Processed " + totalProcessed + " records in total.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

