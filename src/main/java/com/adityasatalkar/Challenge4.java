package com.adityasatalkar;

public class Challenge4 {

	public static String beepBoop(int[] array) {
		String result = "";

		for (int i = 0; i < array.length; i++) {

			int number = array[i];

			boolean mod2 = number % 2 == 0;
			boolean mod5 = number % 5 == 0;

			if (mod2 && mod5) {
				result += "BeepBoop";
			} else if (mod2) {
				result += "Beep";
			} else if (mod5) {
				result += "Boop";
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
				10};
		System.out.println("{");
		System.out.println("\t\"answer\": \"" + beepBoop(numbers) + "\"");
		System.out.println("}");
	}
}
