package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(findAnswer(br.readLine()));
        }
    }

    private static String findAnswer(String input) {
        for (int j = 0; j < input.length(); j++) {
            String subString = input.substring(j);
            String reverse = new StringBuilder(subString).reverse().toString();
            if (subString.equals(reverse)) {
                if (j == 0) {
                    break;
                }
                return input + new StringBuilder(input.substring(0, j)).reverse();
            }
        }
        return input;
    }
}
