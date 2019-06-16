package com.adityasatalkar;

import json.parser.JsonData;
import json.parser.Rule;

import java.util.List;

public class FizzBot {

	public static String variantOne(JsonData jsonData) {

		List<Rule> rules = jsonData.getRules();
		int ruleOne = 0;
		int ruleTwo = 0;
		String responseOne = "";
		String responseTwo = "";
		
		int count = 1;
		
		for(Rule rule : rules) {
			if (count == 1) {
				ruleOne = rule.getNumber();
				responseOne = rule.getResponse();
			} else if (count == 2) {
				ruleTwo = rule.getNumber();
				responseTwo = rule.getResponse();
			}
			count++;
		}

		int[] array = jsonData.getNumbers().stream().mapToInt(i->i).toArray();
		String result = "";

		for (int i = 0; i < array.length; i++) {

			int number = array[i];

			boolean modRuleOne = number % ruleOne == 0;
			boolean modRuleTwo = number % ruleTwo == 0;

			if (modRuleOne && modRuleTwo) {
				result += responseOne + responseTwo;
			} else if (modRuleOne) {
				result += responseOne;
			} else if (modRuleTwo) {
				result += responseTwo;
			} else {
				result += String.valueOf(number);
			}
			if (i != array.length-1) {
				result += " ";
			}
		}
//		System.out.println(result);
		return result;
	}

	public static String variantTwo(JsonData jsonData) {

		List<Rule> rules = jsonData.getRules();
		int ruleOne = 0;
		int ruleTwo = 0;
		int ruleThree = 0;
		String responseOne = "";
		String responseTwo = "";
		String responseThree = "";

		int count = 1;

		for(Rule rule : rules) {
			if (count == 1) {
				ruleOne = rule.getNumber();
				responseOne = rule.getResponse();
			} else if (count == 2) {
				ruleTwo = rule.getNumber();
				responseTwo = rule.getResponse();
			} else if (count == 3) {
				ruleThree = rule.getNumber();
				responseThree = rule.getResponse();
			}
			count++;
		}

		int[] array = jsonData.getNumbers().stream().mapToInt(i->i).toArray();
		String result = "";

		for (int i = 0; i < array.length; i++) {

			int number = array[i];

			boolean modRuleOne = number % ruleOne == 0;
			boolean modRuleTwo = number % ruleTwo == 0;
			boolean modRuleThree = number % ruleThree == 0;

			if (modRuleOne && modRuleTwo && modRuleThree) {
				result += responseOne + responseTwo + responseThree;
			} else if (modRuleOne && modRuleTwo) {
				result += responseOne + responseTwo;
			} else if (modRuleOne && modRuleThree) {
				result += responseOne + responseThree;
			} else if (modRuleTwo && modRuleThree) {
				result += responseTwo + responseThree;
			} else if (modRuleOne){
				result += responseOne;
			} else if (modRuleTwo){
				result += responseTwo;
			} else if (modRuleThree){
				result += responseThree;
			} else {
				result += String.valueOf(number);
			}
			if (i != array.length-1) {
				result += " ";
			}
		}
//		System.out.println(result);
		return result;
	}
}
