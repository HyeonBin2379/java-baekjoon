package algorithm.dp;

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

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i-1 >= 0) {
                    dp[i][j] = dp[i-1][j];
                }
                if (j-weight[i] >= 0) {
                    if (i-1 >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i-1][j]);
                    } else {
                        dp[i][j] = value[i];
                    }
                }
            }
        }
        System.out.println(dp[n-1][k]);
    }
}
