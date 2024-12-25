package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String fileName = "result.out";

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        FileWriter writer = new FileWriter (fileName);

        symptoms.forEach(
                (key, value) -> {
                    try {
                        writer.write(key +": "+ value + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException("Erreur lors de l'ecriture dans le fichier", e);
                    }
                });
        writer.close();
    }
}
