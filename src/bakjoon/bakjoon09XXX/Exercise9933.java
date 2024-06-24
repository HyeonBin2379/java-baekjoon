package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = new HashSet<>();
        int count = Integer.parseInt(br.readLine());

        String answer = "";
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            words.add(input);
            String reversed = new StringBuilder(input).reverse().toString();
            if (words.contains(reversed)) {
                answer = input;
            }
        }
        System.out.println(answer.length() + " " + answer.charAt(answer.length()/2));
    }
}
