package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.FileImplement;
import com.hemebiotech.analytics.service.WriteSymptomDataToFile;
import com.hemebiotech.analytics.service.interfaces.IFile;
import com.hemebiotech.analytics.service.interfaces.ISymptomReader;
import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.util.List;


public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return null;
	}


	//###############################
	//Ancienne version
	//###############################

	public static void main(String args[]) throws Exception {
		IFile fileData = new FileImplement(getFileDataInstance());
		ISymptomWriter fileOutput = new WriteSymptomDataToFile();



		fileOutput.writeToFile(fileData.countOccurrences(fileData.findAll()));
		System.out.println("symptom from file: "+ fileData.countOccurrences(fileData.findAll()));
		fileData.formatData();
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
