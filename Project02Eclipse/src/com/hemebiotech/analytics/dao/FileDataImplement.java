package com.hemebiotech.analytics.dao;

import java.util.List;

public class FileDataImplement implements IData{
    private final FileDataBaseManager fileDataBaseManager;

    public FileDataImplement(FileDataBaseManager fileDataBaseManager) {
        this.fileDataBaseManager = fileDataBaseManager;
    }

    @Override
    public List<String> fetchData() {
        return fileDataBaseManager.readData();
    }
}
