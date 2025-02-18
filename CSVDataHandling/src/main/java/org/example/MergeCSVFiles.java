package org.example;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\student1.csv"; // Path to the first CSV file (ID, Name, Age)
        String file2 = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\student2.csv"; // Path to the second CSV file (ID, Marks, Grade)
        String outputFile = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\merged_students.csv"; // Path to the new merged CSV file

        // Maps to store student data
        Map<Integer, String[]> students1Data = new HashMap<>();
        List<String[]> mergedData = new ArrayList<>();

        // Read the first CSV file and store it in the map (students1Data)
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            String header1 = br1.readLine(); // Read and store the header of the first file
            // Read the students' records and store them in the map
            while ((line = br1.readLine()) != null) {
                String[] student = line.split(",");
                int id = Integer.parseInt(student[0]); // ID is the key
                students1Data.put(id, student); // Store the record using ID as key
            }

            // Read the second CSV file, merge with the map data, and store in the list
            try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
                String header2 = br2.readLine(); // Read and store the header of the second file
                mergedData.add(new String[]{"ID", "Name", "Age", "Marks", "Grade"}); // Add new header to the merged data

                while ((line = br2.readLine()) != null) {
                    String[] student2 = line.split(",");
                    int id = Integer.parseInt(student2[0]);

                    // Find the matching student from the first CSV file
                    if (students1Data.containsKey(id)) {
                        String[] student1 = students1Data.get(id);

                        // Merge the data
                        String[] mergedStudent = new String[5];
                        mergedStudent[0] = String.valueOf(id); // ID
                        mergedStudent[1] = student1[1]; // Name
                        mergedStudent[2] = student1[2]; // Age
                        mergedStudent[3] = student2[1]; // Marks
                        mergedStudent[4] = student2[2]; // Grade

                        // Add the merged record to the list
                        mergedData.add(mergedStudent);
                    }
                }

                // Write the merged data to the new CSV file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                    for (String[] record : mergedData) {
                        bw.write(String.join(",", record));
                        bw.newLine();
                    }
                    System.out.println("CSV files merged successfully.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

