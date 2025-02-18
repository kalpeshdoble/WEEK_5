package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    // Constructor
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}
public class CSVToStudentObjects {
    public static void main(String[] args) {
        String csvFile = "C:\\\\Backup\\\\CSVDataHandling\\\\src\\\\main\\\\java\\\\org\\\\example\\\\student.csv"; // Path to your CSV file
        String line;
        String csvSplitBy = ","; // CSV delimiter (comma)

        // List to store the student objects
        List<Student> students = new ArrayList<>();

        // Try-with-resources to ensure the resources are closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header (if present) and ignore it
            String header = br.readLine();

            // Read each line (representing a student record)
            while ((line = br.readLine()) != null) {
                // Split the line into individual fields based on the delimiter
                String[] studentData = line.split(csvSplitBy);

                // Convert the data into a Student object
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                int marks = Integer.parseInt(studentData[3]);

                // Create a Student object and add it to the list
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            // Print the student objects
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


