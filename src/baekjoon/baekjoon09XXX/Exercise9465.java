package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                stickers[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[][] dp = new int[2][n+1];
            dp[0][1] = stickers[0][0];
            dp[1][1] = stickers[1][0];
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j-1];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j-1];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
