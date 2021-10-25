package com.detectlanguage.utils;

public class Result {
    public String language;
    public boolean isReliable;
    public double confidence;

    public Result(BuilderResult builder) {
        language = builder.language;
        isReliable = builder.isReliable;
        confidence = builder.confidence;
    }

    public String getTitle() {
        return language;
    }

    public Boolean getAuthor() {
        return isReliable;
    }

    public double getDate() {
        return confidence;
    }

    public static final class BuilderResult {
        public String language;
        public boolean isReliable;
        public double confidence;

        public BuilderResult() {
            isReliable = true;
            confidence = 100.00;
        }

        public BuilderResult setLanguage(String language) {
            language = language;
            return this;
        }

        public BuilderResult setIsReliable(String isReliable) {
            isReliable = isReliable;
            return this;
        }

        public BuilderResult setConfidence(String confidence) {
            confidence = confidence;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
