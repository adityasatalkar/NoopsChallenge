package com.adityasatalkar;

import api.API;
import json.parser.JsonData;
import json.parser.PostResponseJsonData;

/**
 * Hello world!
 *
 */
public class App {

    public static String initialURL = "/fizzbot/questions/1";
    public static String initAnswer = "{\n" +
            "    \"answer\": \"JAVA\"\n" +
            "}";


    public static void noopsChallengeInterview(PostResponseJsonData postResponseJsonData) throws Exception {
        API api = new API();
        String url = postResponseJsonData.getNextQuestion();

        System.out.println(url);

        JsonData getJsonData = api.get(url);

        System.out.println(getJsonData.getMessage());
        System.out.println(getJsonData.getNumbers());

        int numberOfRules = getJsonData.getRules().size();

        String answer = "";
        if (numberOfRules == 2) {
            answer = FizzBot.variantOne(getJsonData);
        } else if (numberOfRules == 3) {
            answer = FizzBot.variantTwo(getJsonData);
        }

        postResponseJsonData = api.post(url, api.answerJsonifyString(answer));
        System.out.println("New challenge is : " + postResponseJsonData.getNextQuestion());

        System.out.println("\n\n******************************************************************************\n\n");

        if (postResponseJsonData.getResult() != "interview complete") {
            noopsChallengeInterview(postResponseJsonData);
        }
    }

    public static void main(String[] args) throws Exception {
        API api = new API();

        PostResponseJsonData postResponseJsonData = api.post(initialURL, initAnswer);

        noopsChallengeInterview(postResponseJsonData);
    }
}
