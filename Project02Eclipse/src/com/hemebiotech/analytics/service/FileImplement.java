package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.implement.IFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileImplement implements IFile {
    private final FileDataBaseManager fileDataBaseManager;

    public FileImplement(FileDataBaseManager fileDataBaseManager) {
        this.fileDataBaseManager = fileDataBaseManager;
    }

    @Override
    public List<String> findAll() {
        return fileDataBaseManager.readData();
    }

    @Override
    public Map<String, Integer> countOccurrences() {
        Map<String, Integer> countMap = new HashMap<>();

        findAll().forEach(
                item -> countMap.put(item, countMap.getOrDefault(item, 0) + 1));

        return countMap;
    }

    @Override
    public Map<String, Integer> sortAlphabet() {
        return new TreeMap<>(countOccurrences());
    }
}
