package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5350 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n+1][W+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= W; j++) {
                    dp[i][j] = (j >= w) ? Math.max(dp[i-1][j], dp[i-1][j-w]+v) : dp[i-1][j];
                }
            }
            System.out.println(dp[n][W]);
        }
    }
}
