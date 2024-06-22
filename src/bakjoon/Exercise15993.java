package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15993 {

    private static final long MOD = 1000000009;
    private static final long[][] dp = new long[100001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        calculate();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(dp[n][1] + " " + dp[n][0]);
        }
    }

    private static void calculate() {
        dp[0][0] = 1;
        for (int i = 1; i <= 100000; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (i >= k) {
                        dp[i][j] += dp[i - k][(j+1) % 2];
                    }
                }
                dp[i][j] %= MOD;
            }
        }
    }
}
