package com.detectlanguage.steps;

import com.detectlanguage.Result;
import com.detectlanguage.builder.BatchDetectRequestBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.ArrayList;
import java.util.List;

public class BaseStep {
    List<Result> resultList;
    List<List<Result>> resultLists;
    List<Result> requestDataList;
    List<List<Result>> resultDataLists;

    public BatchDetectRequestBuilder requestData;

    public BaseStep(BatchDetectRequestBuilder requestData){
        this.requestData = requestData;
    }


















    protected List<List<String>> languagesList;
    protected List<String> languageList;
    protected List<String> textList;

    public void initiate_new_context(){
        System.out.println("Initiate new context in with @Before in BaseStep");
        languagesList = new ArrayList<>();
        languageList = new ArrayList<>();
        textList = new ArrayList<>();
        resultList = new ArrayList<>();
    }

    void clearLists(){
        languagesList.clear();
        languageList.clear();
        textList.clear();
        resultList.clear();
    }
}
