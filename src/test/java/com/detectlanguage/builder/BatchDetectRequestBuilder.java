package com.detectlanguage.builder;

import com.detectlanguage.utils.Result;

import java.util.ArrayList;
import java.util.List;

public class BatchDetectRequestBuilder implements RequestBuilder {
    private List<String> languages;
    private List<String> texts;
    private List<Result> resultList;

    public BatchDetectRequestBuilder(){
        languages = new ArrayList<>();
        texts = new ArrayList<>();
        resultList = new ArrayList<>();
    }

    @Override
    public void setLanguage(String language) {
        this.languages.add(language);
    }

    @Override
    public void setText(String text) {
        this.texts.add(text);
    }

    public List<String> getLanguages() {
        return languages;
    }

    public List<String> getTexts() {
        return texts;
    }

    public List<Result> getRequestList(){
        Result result = new Result.BuilderResult().
                setLanguage(languages.get(0)).
                build();
        resultList.add(result);
        return resultList;
    }

    public List<List<Result>> getRequestLists(){
            List<List<Result>> resultLists = new ArrayList<>()
        return resultLists;
    }
}
