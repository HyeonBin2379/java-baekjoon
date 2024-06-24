package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15988 {

    private static final long[] dp = new long[1000001];
    private static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setCounts();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }

    private static void setCounts() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % MOD;
        }
    }
}
