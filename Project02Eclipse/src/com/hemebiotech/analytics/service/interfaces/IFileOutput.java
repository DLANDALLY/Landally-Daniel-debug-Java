package com.hemebiotech.analytics.service.interfaces;

import java.io.IOException;
import java.util.Map;

public interface IFileOutput {
    void writeToFile(Map<String, Integer> map) throws IOException;
}
