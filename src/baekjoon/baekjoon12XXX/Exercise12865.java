package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= k; j++) {
                dp[i][j] = (w[i] > j) ? dp[i-1][j] : Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
