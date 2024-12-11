package com.hemebiotech.analytics.service.interfaces;


import java.util.List;
import java.util.Map;

public interface IFile {
    List<String> findAll();

    Map<String, Integer>countOccurrences(List<String> data);

}
