package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file and convert it into a JsonNode (tree-like structure)
            File jsonFile = new File("C:\\Backup\\JsonData\\src\\main\\java\\org\\example\\File.jason"); // JSON file path
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // Iterate through each user in the JSON array
            for (JsonNode userNode : rootNode) {
                // Extract name and email fields from the JSON
                String name = userNode.get("name").asText();
                String email = userNode.get("email").asText();

                // Print the extracted fields
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

