package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidationExample {
    public static void main(String[] args) {
        // Valid JSON example
        String validJson = "{\"name\":\"John\", \"age\":30, \"email\":\"john@example.com\"}";

        // Invalid JSON example (missing closing curly brace)
        String invalidJson = "{\"name\":\"John\",\"age\":30, \"email\":\"john@example.com\"";

        // Validate the valid JSON
        System.out.println("Valid JSON Check:");
        validateJson(validJson);

        // Validate the invalid JSON
        System.out.println("\nInvalid JSON Check:");
        validateJson(invalidJson);
    }

    public static void validateJson(String json) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Try parsing the JSON string
            objectMapper.readTree(json);  // If JSON is valid, it will not throw an exception

            System.out.println("The JSON structure is valid.");
        } catch (Exception e) {
            // If parsing fails, the JSON is invalid
            System.out.println("The JSON structure is invalid: " + e.getMessage());
        }
    }
}

