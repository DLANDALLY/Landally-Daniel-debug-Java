package com.hemebiotech.analytics.service.interfaces;

import java.util.List;
import java.util.Map;

public interface ISymptomReader {
    List<String> getSymptoms();
    Map<String, Integer> countSymptoms(List<String> symptoms);
    Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms);
}
