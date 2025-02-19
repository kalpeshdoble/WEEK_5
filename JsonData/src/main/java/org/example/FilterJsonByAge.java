package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.JSONArray;


public class FilterJsonByAge {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonData = "[{\"name\":\"kalpesh\",\"age\":35}, {\"name\":\"kapil\",\"age\":29}, {\"name\":\"nishant\",\"age\":22}]";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonData);

        ArrayNode filteredArray = objectMapper.createArrayNode();

        for (JsonNode node : rootNode){
            if (node.get("age").asInt()>25){
                filteredArray.add(node);
            }
        }
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray);
        System.out.println(jsonString);
    }
}

