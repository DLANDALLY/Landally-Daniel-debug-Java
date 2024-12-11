package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.FileDataBaseManager;
import com.hemebiotech.analytics.service.FileImplement;
import com.hemebiotech.analytics.service.FileOutputService;
import com.hemebiotech.analytics.service.interfaces.IFile;
import com.hemebiotech.analytics.service.interfaces.IFileOutput;


public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		IFile fileData = new FileImplement(getFileDataInstance());
		IFileOutput fileOutput = new FileOutputService();

		fileOutput.writeToFile(fileData.countOccurrences(fileData.findAll()));

		System.out.println("symptom from file: "+ fileData.countOccurrences(fileData.findAll()));
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
