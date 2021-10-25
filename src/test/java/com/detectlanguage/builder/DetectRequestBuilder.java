package com.detectlanguage.builder;

import java.util.List;

public class DetectRequestBuilder implements RequestBuilder {
    private List<String> language;
    private String text;

    @Override
    public void setLanguage(String language) {
        this.language.add(language);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
