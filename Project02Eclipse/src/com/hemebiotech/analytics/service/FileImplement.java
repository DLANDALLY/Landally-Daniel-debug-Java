package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.interfaces.IFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileImplement implements IFile {
    private final FileDataBaseManager fileDataBaseManager;
    public FileImplement(FileDataBaseManager fileDataBaseManager) {
        this.fileDataBaseManager = fileDataBaseManager;
    }

    /**
     * Displays all content of the file
     * @return List of data
     */
    @Override
    public List<String> findAll() {
        return fileDataBaseManager.readData();
    }

    /**
     * Counts occurrences of each symptom in the file
     * @param data list
     * @return Map of symptoms and their occurrences
     */
    @Override
    public Map<String, Integer> countOccurrences(List<String> data) {
        Map<String, Integer> countMap = new TreeMap<>(); //Sorted in their natural order

        data.forEach(item -> countMap.merge(item, 1, Integer::sum));
        //data.forEach(item -> countMap.put(item, countMap.getOrDefault(item, 0) + 1));

        return countMap;
    }

}
