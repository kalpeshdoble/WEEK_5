package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a new ObjectNode (representing the JSON structure)
            ObjectNode studentNode = objectMapper.createObjectNode();

            // Add fields to the JSON object
            studentNode.put("name", "John Doe");
            studentNode.put("age", 20);

            // Create an array of subjects
            ArrayNode subjectsNode = objectMapper.createArrayNode();
            subjectsNode.add("Mathematics");
            subjectsNode.add("Physics");
            subjectsNode.add("Computer Science");

            // Add the subjects array to the student object
            studentNode.put("subjects", subjectsNode);

            // Convert the ObjectNode to a JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentNode);

            // Print the JSON
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
