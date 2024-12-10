package com.hemebiotech.analytics.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataBaseManager {
    private static FileDataBaseManager instance;
    private static final String DATABASE_FILE = "symptoms.txt";

    private FileDataBaseManager() {}

    public static synchronized FileDataBaseManager getInstance() {
        return (instance == null) ? instance = new FileDataBaseManager(): instance;
    }


//    public String readData() {
//        StringBuilder data = new StringBuilder();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
//            String line;
//            while ((line = reader.readLine())!= null) {
//                data.append(line).append("\n");
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return data.toString();
//    }

    public List<String> readData() {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
