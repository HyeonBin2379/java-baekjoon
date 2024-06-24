package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise16195 {

    private static final long MOD = 1000000009;
    private static final long[][] dp = new long[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        calculate();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long answer = IntStream.rangeClosed(1, m)
                    .mapToLong(index -> dp[n][index])
                    .reduce(0, (a, b) -> Long.sum(a, b) % MOD);
            System.out.println(answer % MOD);
        }
    }

    private static void calculate() {
        dp[0][0] = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (i >= k) {
                        dp[i][j] += dp[i-k][j-1];
                    }
                }
                dp[i][j] %= MOD;
            }
        }
    }
}
