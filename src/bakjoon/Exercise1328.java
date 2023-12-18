package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1328 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        br.close();

        long[][][] dp = new long[num + 1][left + 1][right + 1];
        dp[1][1][1] = 1;
        for (int i = 2; i < num+1; i++) {
            for (int j = 1; j < left+1; j++) {
                for (int k = 1; k < right+1; k++) {
                    dp[i][j][k] = dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k]*(i-2);
                    dp[i][j][k] %= MOD;
                }
            }
        }
        System.out.println(dp[num][left][right]);
    }
}
