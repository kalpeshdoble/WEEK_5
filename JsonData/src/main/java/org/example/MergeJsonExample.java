package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON strings
            String json1 = "{\"name\":\"kalpesh doble\",\"age\":20}";
            String json2 = "{\"email\":\"kalpeshdoble@example.com\",\"address\":\"Bhopal Madhya pradesh\"}";

            // Convert JSON strings to JsonNode objects
            ObjectNode jsonNode1 = (ObjectNode)objectMapper.readTree(json1);
            ObjectNode jsonNode2 = (ObjectNode)objectMapper.readTree(json2);

            // Merge jsonNode2 into jsonNode1 (without explicit casting)
            jsonNode1.setAll(jsonNode2);

            // Convert merged JsonNode back to JSON string
            String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode1);

            // Print the merged JSON
            System.out.println(mergedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

