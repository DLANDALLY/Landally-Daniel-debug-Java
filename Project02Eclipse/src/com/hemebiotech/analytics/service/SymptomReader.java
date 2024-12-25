package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.interfaces.ISymptomReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomReader implements ISymptomReader {
    private final FileDataBaseManager fileDataBaseManager;

    public SymptomReader(FileDataBaseManager fileDataBaseManager) {
        this.fileDataBaseManager = fileDataBaseManager;
    }

    /**
     * Displays all content of the file
     * @return List of data
     */
    @Override
    public List<String> getSymptoms() {
        return fileDataBaseManager.readData();
    }

    /**
     * Counts occurrences of each symptom in the file
     * @param symptoms list
     * @return Map of symptoms and their occurrences
     */
    @Override
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> countMap = new HashMap<>();
        symptoms.forEach(item -> countMap.merge(item, 1, Integer::sum));

        return countMap;
    }

    /**
     * Counts occurrences of each symptom in the file
     * @param symptoms list
     * @return Map of symptoms and their occurrences
     */
    @Override
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }
}
