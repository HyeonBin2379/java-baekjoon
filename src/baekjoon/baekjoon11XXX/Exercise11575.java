package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char[] input = br.readLine().toCharArray();

            StringBuilder sb = new StringBuilder();
            for (char c : input) {
                int num = (a * (c - 'A') + b) % 26;
                sb.append((char) ('A' + num));
            }
            System.out.println(sb);
        }
    }
}
