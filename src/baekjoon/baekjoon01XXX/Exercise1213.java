package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int[] alphabet = new int[26];
        for (char c : input) {
            alphabet[c - 'A']++;
        }

        int count = (int) Arrays.stream(alphabet).filter(value -> value % 2 == 1).count();
        if (count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder answer = new StringBuilder();
        int index = 0, odd = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) {
                continue;
            }
            int len = alphabet[i];
            if (len % 2 == 1) {
                len -= 1;
                odd = i;
            }
            answer.insert(index, String.valueOf((char)('A'+i)).repeat(len));
            index = answer.length()/2;
        }
        if (input.length % 2 == 1) {
            answer.insert(index, (char) ('A' + odd));
        }
        System.out.println(answer);
    }
}
