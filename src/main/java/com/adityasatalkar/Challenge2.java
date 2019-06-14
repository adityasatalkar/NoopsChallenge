package com.adityasatalkar;

public class Challenge2 {

	public static void main(String[] args) {
		int[] numbers = {
			8,
			59,
			36,
			4,
			55};

		System.out.println("{");
		System.out.println("\t\"answer\": \"" + Challenge1.fizzBuzz(numbers) + "\"");
		System.out.println("}");
	}
}
