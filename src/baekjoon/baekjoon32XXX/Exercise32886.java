package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32886 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String performance = br.readLine();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String result = (performance.equals("encrypt")) ? encrypt(input) : decrypt(input);
            System.out.println(result);
        }
    }

    private static String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            char newChar = (char)((c - 'a' + 1) % 26 + 'a');
            result.append(newChar);
        }
        return result.toString();
    }

    private static String decrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            char newChar = (char)((c - 'a' + 25) % 26 + 'a');
            result.append(newChar);
        }
        return result.toString();
    }
}
