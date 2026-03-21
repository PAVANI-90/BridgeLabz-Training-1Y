package com.gla.ExceptionHandling.CheckedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            // Try to open the file
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

            String line;
            // Read and print file contents
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            // Handle exception if file is not found or cannot be read
            System.out.println("File not found");
        }
    }
}
