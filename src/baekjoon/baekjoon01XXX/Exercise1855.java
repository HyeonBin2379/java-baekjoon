package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1855 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[][] encode = new char[input.length()/k][k];
        for (int i = 0; i < input.length()/k; i++) {
            for (int j = 0; j < k; j++) {
                encode[i][j] = (i % 2 == 0) ? input.charAt(i*k + j) : input.charAt(i*k + k-1-j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length()/k; j++) {
                sb.append(encode[j][i]);
            }
        }
        System.out.println(sb);
    }
}
