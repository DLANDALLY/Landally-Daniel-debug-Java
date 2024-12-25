package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String fileName = "result.out";

    /**
     * Write the symptom occurrences to a file
     * @param data symptom occurrences
     * @throws IOException if error occurs during file writing
     */
    @Override
    public void writeToFile(Map<String, Integer> data) throws IOException {
        FileWriter writer = new FileWriter (fileName);

        data.forEach(
                (key, value) -> {
                    try {
                        writer.write(key +": "+ value + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException("Erreur lors de l'ecriture dans le fichier", e);
                    }
                });
        writer.close();
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

    }
}
