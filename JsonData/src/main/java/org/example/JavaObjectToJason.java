package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
 class Car {
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

public class JavaObjectToJason {
    public static void main(String[] args) {
        try {
            // Create an instance of the Car class
            Car myCar = new Car("Tesla", "Model 3", 2022);

            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the Car object to JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(myCar);

            // Print the JSON string
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

