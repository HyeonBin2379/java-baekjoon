package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise7515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = (i < 2) ? i+1 : dp[i-1] + dp[i-2];
        }
        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(String.format("Scenario %d: %d\n\n", i, dp[n]));
        }
        System.out.print(sb);
    }
}
