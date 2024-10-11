package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise22115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] caffeine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n+1][k+1];
        Arrays.fill(dp[0], (int)1e9);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j-caffeine[i-1] >= 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-caffeine[i-1]]+1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k] == (int)1e9 ? -1 : dp[n][k]);
    }
}
