package com.adityasatalkar;

public class Challenge6 {

    public static String meetTheNoops(int[] array) {
        String result = "";

        for (int i = 0; i < array.length; i++) {

            int number = array[i];

            boolean mod3 = number % 3 == 0;
            boolean mod5 = number % 5 == 0;
            boolean mod7 = number % 7 == 0;

            if (mod3 && mod5 && mod7) {
                result += "MeetTheNoops";
            } else if (mod3 && mod5) {
                result += "MeetThe";
            } else if (mod3 && mod7) {
                result += "MeetNoops";
            } else if (mod5 && mod7) {
                result += "TheNoops";
            } else if (mod3){
                result += "Meet";
            } else if (mod5){
                result += "The";
            } else if (mod7){
                result += "Noops";
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
                {21,
                97,
                96,
                54,
                29,
                36,
                31,
                69,
                43,
                88,
                105};
        System.out.println("{");
        System.out.println("\t\"answer\": \"" + meetTheNoops(numbers) + "\"");
        System.out.println("}");
    }
}