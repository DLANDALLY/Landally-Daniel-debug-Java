package com.hemebiotech.analytics;

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
		return reader.getSymptoms();
	}

}
