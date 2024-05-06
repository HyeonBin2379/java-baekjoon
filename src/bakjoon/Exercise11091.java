package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise11091 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] alphabet = new int[26];
            char[] input = br.readLine().toLowerCase().toCharArray();
            for (char c : input) {
                if (c >= 'a' && c <= 'z') {
                    alphabet[c - 'a']++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (alphabet[j] == 0) {
                    sb.append((char)('a' + j));
                }
            }
            System.out.println(sb.isEmpty() ? "pangram" : "missing " + sb);
        }
    }
}
