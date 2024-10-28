package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32560 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] letter1 = new int[26];
        for (char ch : br.readLine().toCharArray()) {
            letter1[ch-'a']++;
        }
        int[] letter2 = new int[26];
        for (char ch : br.readLine().toCharArray()) {
            letter2[ch-'a']++;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letter1[i] == 0 && letter2[i] == 0) {
                continue;
            }
            answer.append(String.valueOf((char)('a'+i)).repeat(Math.max(letter1[i], letter2[i])));
        }
        System.out.println(answer);
    }
}
