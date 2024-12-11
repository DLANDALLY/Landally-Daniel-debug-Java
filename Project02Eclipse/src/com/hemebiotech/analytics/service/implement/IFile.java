package com.hemebiotech.analytics.service.implement;


import java.util.List;
import java.util.Map;

public interface IFile {
    List<String> findAll();

    Map<String, Integer>countOccurrences();

    Map<String, Integer>sortAlphabet();

}
