package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.AnalyticsCounter;
import com.hemebiotech.analytics.service.SymptomReader;
import com.hemebiotech.analytics.service.WriteSymptomDataToFile;
import com.hemebiotech.analytics.service.interfaces.ISymptomReader;
import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ISymptomReader reader = new SymptomReader(getFileDataInstance());
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        System.out.println("GetSymptoms : "+ analytics.getSymptoms());
        System.out.println("CountSymptoms : "+ analytics.countSymptoms(analytics.getSymptoms()));
        System.out.println("SortSymptoms : "+ analytics.sortSymptoms(analytics.countSymptoms(analytics.getSymptoms())));

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
