package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int pages = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (j >= days) ? Math.max(dp[i-1][j], dp[i-1][j-days] + pages) : dp[i-1][j];
            }
        }
        System.out.println(dp[m][n]);
    }
}
