package api;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParseJson {

    static String json = "{\n" +
            "    \"nextQuestion\": \"/fizzbot/questions/nQNPopOIAK4dvVXEGxSRKuAgte6Bb5q2vA3WstxdPnQ\",\n" +
            "    \"message\": \"You're off to a great start!\",\n" +
            "    \"result\": \"correct\"\n" +
            "}";

    static String questionJson = "{\n" +
            "    \"message\": \"Here are a few more numbers. The same rules apply.\",\n" +
            "    \"rules\": [\n" +
            "        {\n" +
            "            \"number\": 3,\n" +
            "            \"response\": \"Fizz\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"number\": 5,\n" +
            "            \"response\": \"Buzz\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"numbers\": [\n" +
            "        8,\n" +
            "        59,\n" +
            "        36,\n" +
            "        4,\n" +
            "        55\n" +
            "    ]\n" +
            "}";

    public static String getUrlFromJsonResponse(String json) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        String nextQuestion = "";
        if (jsonObject.has("nextQuestion")) {
            nextQuestion = jsonObject.getAsJsonObject().get("nextQuestion").getAsString();
        }
        return nextQuestion;
    }

    public static List getNumbersFromJsonResponse(String questionJson) {

        JsonObject jsonObject = new JsonParser().parse(questionJson).getAsJsonObject();
        Type listType = new TypeToken<LinkedList<Integer>>() {}.getType();
        List<Integer> numbers = new ArrayList<>();

        if (jsonObject.has("numbers")) {
            numbers = new Gson().fromJson(jsonObject.get("numbers"), listType);
        }
        return numbers;
    }


    public static void main(String[] args) {
        System.out.println(getUrlFromJsonResponse(json));

        System.out.println(getNumbersFromJsonResponse(questionJson));
    }
}