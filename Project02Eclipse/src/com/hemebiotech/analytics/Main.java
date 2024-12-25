package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.SymptomReader;
import com.hemebiotech.analytics.service.WriteSymptomDataToFile;
import com.hemebiotech.analytics.service.interfaces.ISymptomReader;
import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ISymptomReader reader = new SymptomReader(getFileDataInstance());
        ISymptomWriter writer = new WriteSymptomDataToFile();

        System.out.println("GetSymptoms : "+ reader.getSymptoms());
        System.out.println("CountSymptoms : "+ reader.countSymptoms(reader.getSymptoms()));
        System.out.println("SortSymptoms : "+ reader.sortSymptoms(reader.countSymptoms(reader.getSymptoms())));

        writer.writeSymptoms(reader.sortSymptoms(reader.countSymptoms(reader.getSymptoms())));
    }

    /**
     * Get single instance of Data file
     * @return single instance of Data
     */
    public static FileDataBaseManager getFileDataInstance(){
        FileDataBaseManager fileDataBaseManager = FileDataBaseManager.getInstance();
        return fileDataBaseManager;
    }
}
