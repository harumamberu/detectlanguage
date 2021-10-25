package com.detectlanguage.runner;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) throws APIError {
        DetectLanguage.apiKey = "d5c34e4df1f95cf94063141ca177f339";
        String string = "string";
        String[] stringsArray = {string, "стрінг"};

        simpleDetect(string);
        detect(string);
        detect(stringsArray);
        detect("$%$%$(*&");
    }

    private static void simpleDetect(String string) throws APIError {
        System.out.println(DetectLanguage.simpleDetect(string));
        System.out.println("\n");
    }

    private static void detect(String string) throws APIError {
        System.out.println(DetectLanguage.detect(string).stream().map(Object::toString).collect(Collectors.joining()));
        System.out.println(DetectLanguage.detect(string).get(0).language);
        //DetectLanguage.detect(string).sort();
        System.out.println("\n");
    }

    private static void detect(String[] strings) throws APIError {
        System.out.println(DetectLanguage.detect(strings));
    }
}
