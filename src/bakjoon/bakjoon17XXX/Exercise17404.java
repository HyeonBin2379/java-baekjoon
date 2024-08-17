package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17404 {

    private static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = INF;
        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[n][3];
            for (int j = 0; j < 3; j++) {
                dp[0][j] = (i == j) ? cost[0][j] : INF;
            }
            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    answer = Math.min(dp[n-1][j], answer);
                }
            }
        }
        System.out.println(answer);
    }
}
