package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int answer = 1;
            int len = 1;

            while (true) {
                if (answer % n == 0) {
                    sb.append(len).append("\n");
                    break;
                }
                answer = answer*10+1;
                answer %= n;
                len++;
            }
        }
        System.out.println(sb);
    }
}