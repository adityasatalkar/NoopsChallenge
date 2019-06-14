// https://api.noopschallenge.com/fizzbot/questions/DmsVRw515Udx07iNE8QtwEZzxkLQ6x-M0YDJaN1JptA

package com.adityasatalkar;

public class Challenge1 {

	public static String fizzBuzz(int[] array) {
		String result = "";

		for (int i = 0; i < array.length; i++) {

			int number = array[i];

			boolean mod3 = number % 3 == 0;
			boolean mod5 = number % 5 == 0;

			if (mod3 && mod5) {
				result += "FizzBuzz";
			} else if (mod3) {
				result += "Fizz";
			} else if (mod5) {
				result += "Buzz";
			} else {
				result += String.valueOf(number);
			}
			if (i != array.length-1) {
				result += " ";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] numbers =
				{1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12,
				13,
				14,
				15};
		System.out.println("{");
		System.out.println("\t\"answer\": \"" + fizzBuzz(numbers) + "\"");
		System.out.println("}");
	}
}
