package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9226 {

    private static final String VOWELS = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            String newString = input + "ay";
            for (int i = 0; i < input.length(); i++) {
                if (VOWELS.contains(String.valueOf(input.charAt(i)))) {
                    newString = input.substring(i) + input.substring(0, i) + "ay";
                    break;
                }
            }
            System.out.println(newString);
        }
    }
}
