package com.detectlanguage.steps;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.User;
import com.detectlanguage.builder.BatchDetectRequestBuilder;
import com.detectlanguage.builder.DetectRequestBuilder;
import com.detectlanguage.builder.RequestBuilder;
import com.detectlanguage.errors.APIError;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class StepsDefinitionHeap extends BaseStep{

    public StepsDefinitionHeap(BatchDetectRequestBuilder requestData) {
        super(requestData);
    }

    @Given("User with API token")
    public void user_with_API_token() {
        DetectLanguage.apiKey = new User().getApi_token();
    }

    @Given("User with {string} token")
    public void user_with_token(String token) {
        DetectLanguage.apiKey = new User(token).getApi_token();
    }

    @Before
    public void instanceData(){
        requestData = new BatchDetectRequestBuilder();
        System.out.println("\n");
    }

    @Given("the {string} language")
    public void language(String language) {
        requestData.setLanguage(language);
        System.out.println("setted language from list " + requestData.getLanguages().get(0));
    }

    @Given("the {string} string")
    public void text_string(String text) {
        requestData.setText(text);
        System.out.println("setted text from list " + requestData.getTexts().get(0));
    }

    @When("User sends Detect request")
    public void user_sends_detect_request() throws APIError {
        resultList = DetectLanguage.detect(requestData.getTexts().get(0));
    }

    @When("User sends BatchDetect request")
    public void user_sends_batchDetect_request() throws APIError {
        String[] texts = requestData.getTexts().stream().toArray(String[]::new);
        resultLists = DetectLanguage.detect(texts);
    }

    //move to VerificationSteps
    @Then("the {string} language was received")
    public void the_language_was_received(String responceLanguage) {
        Assert.assertFalse(resultList.isEmpty());
        Assert.assertTrue(resultList.get(0).language.
                equalsIgnoreCase(responceLanguage));
        System.out.println("Assert that responceLanguage is " + responceLanguage);
    }

    @ParameterType(value = "true|false")
    public Boolean reliability(String value) {
        return Boolean.valueOf(value);
    }

    @Then("the reliability of result {reliability}")
    public void the_realibaility_of_result(Boolean booleanExp){
        Assert.assertFalse(resultList.isEmpty());
        Assert.assertEquals(resultList.get(0).isReliable, booleanExp);
    }

    @Then("the reliability of result is false")
    public void the_realibaility_of_result_is_false(){
        Assert.assertFalse(resultList.isEmpty());
        Assert.assertFalse(resultList.get(0).isReliable);
    }


    @Then("the {string} response was received")
    public void the_response_was_received(String string) {

    }

    @Then("the confidence was received")
    public void theConfidenceWasReceived() {
        Assert.assertTrue(resultList.get(0).confidence > 0);
    }

    @Then("the actual result equls expected")
    public void actual_result_equals_expected(){
        Assert.assertTrue(resultList.equals(requestData.getResultList()));
    }
}
