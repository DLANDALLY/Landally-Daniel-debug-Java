package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.dao.IData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {
    private IData idata;

    public void setIdata(IData idata) {
        this.idata = idata;
    }

    public List<String> getData() {
        return idata.fetchData();
    }


    public Map<String, Integer> countOccurrences(List<String> data) {
        Map<String, Integer> countMap = new HashMap<>();

        data.forEach(
                item -> countMap.put(item, countMap.getOrDefault(item, 0) + 1));

        return countMap;
    }
}
