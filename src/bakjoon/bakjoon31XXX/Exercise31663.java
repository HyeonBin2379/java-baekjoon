package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] words = new String[count];

        int maxLen = 0;
        for (int i = 0; i < count; i++) {
            words[i] = br.readLine();
            maxLen = Math.max(words[i].length(), maxLen);
        }

        int[][] ascii = new int[count][maxLen];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                ascii[i][j] = words[i].charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int sum = 0;
            int n = count;
            for (int j = 0; j < count; j++) {
                if (ascii[j][i] == 0) {
                    n--;
                }
                sum += ascii[j][i];
            }
            sb.append((char)(sum/n));
        }
        System.out.println(sb);
    }
}
