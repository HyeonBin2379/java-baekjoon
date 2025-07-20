package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cost = Integer.parseInt(br.readLine());

            int[][] dp = new int[n][cost+1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= cost; j++) {
                    if (i-1 >= 0) { // i번째 동전 사용
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j-coins[i] >= 0) {  // i번째 동전 미사용
                        dp[i][j] += dp[i][j-coins[i]];
                    }
                }
            }
            System.out.println(dp[n-1][cost]);
        }
    }
}
