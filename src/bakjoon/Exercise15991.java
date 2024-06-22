package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15991 {

    private static final long MOD = 1000000009;
    private static final long[] dp = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        calculate();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(dp[n]);
        }
    }

    private static void calculate() {
        dp[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            if (i < 6) {
                dp[i] = (i % 2 == 1) ? dp[i-1] : dp[i-1]+1;
                continue;
            }

            for (int k = 1; k <= 3; k++) {
                dp[i] += dp[i-2*k];
            }
            dp[i] %= MOD;
        }
    }
}
