package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] soldier = new int[n+1];
        for (int i = 1; i <= n; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (soldier[i] < soldier[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(n-max);
    }
}
