package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
 class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ListToJsonArrayExample {
    public static void main(String[] args) {
        try {
            // Create a list of Person objects
            List<Person> people = new ArrayList<>();
            people.add(new Person("John", 30));
            people.add(new Person("Jane", 25));
            people.add(new Person("Alice", 35));

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the list to a JSON array
            String jsonArray = objectMapper.writeValueAsString(people);

            // Print the JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
