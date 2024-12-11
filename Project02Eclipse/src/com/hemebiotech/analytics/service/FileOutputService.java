package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.service.interfaces.IFile;
import com.hemebiotech.analytics.service.interfaces.IFileOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileOutputService implements IFileOutput {

    @Override
    public void writeToFile(String fileName, Map<String, Integer> data) throws IOException {
        FileWriter writer = new FileWriter (fileName);

        data.forEach(
                (key, value) -> {
                    try {
                        writer.write(key +":<3 "+ value + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException("Erreur lors de l'ecriture dans le fichier", e);
                    }
                });
        writer.close();
    }
}
