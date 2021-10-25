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
}
