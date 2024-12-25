package com.hemebiotech.analytics.service.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
