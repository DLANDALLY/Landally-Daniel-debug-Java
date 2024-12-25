package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.service.interfaces.ISymptomReader;
import com.hemebiotech.analytics.service.interfaces.ISymptomWriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		return reader.countSymptoms(symptoms);
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return reader.sortSymptoms(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            System.err.println("Error writing symptoms to file: " + e.getMessage());
        }
	}

}
