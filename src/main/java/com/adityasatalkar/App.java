package com.adityasatalkar;

import json.parser.JsonData;
import json.parser.PostResponseJsonData;

/**
 * NOOPS Challenge
 * Fizzbot wants to interview you
 * https://noopschallenge.com/challenges/fizzbot
 */
public class App {

    public static String INITIAL_URL = "/fizzbot/questions/1";
    public static String INITIAL_ANSWER = "{\n" +
            "    \"answer\": \"JAVA\"\n" +
            "}";
    public static String INTERVIEW_COMPLETE = "interview complete";

    public static void noopsChallengeInterview(PostResponseJsonData postResponseJsonData) throws Exception {
        String url = postResponseJsonData.getNextQuestion();

        JsonData getJsonData = API.get(url);

        int numberOfRules = getJsonData.getRules().size();

        String answer = "";
        if (numberOfRules == 2) {
            answer = FizzBot.variantOne(getJsonData);
        } else if (numberOfRules == 3) {
            answer = FizzBot.variantTwo(getJsonData);
        }

        postResponseJsonData = API.post(url, API.answerJsonifyString(answer));

        if (!INTERVIEW_COMPLETE.equalsIgnoreCase(postResponseJsonData.getResult())) {
            noopsChallengeInterview(postResponseJsonData);
        }
    }

    public static void main(String[] args) throws Exception {
        API.get("/fizzbot");

        PostResponseJsonData postResponseJsonData = API.post(INITIAL_URL, INITIAL_ANSWER);

        noopsChallengeInterview(postResponseJsonData);

        System.out.println("Check NoopsChallengeCompleted.txt file for output");
    }
}