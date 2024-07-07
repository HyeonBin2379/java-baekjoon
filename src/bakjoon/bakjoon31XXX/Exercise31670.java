package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise31670 {

    private static final long INF = 1000000000000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] seq = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }

        long[][] dp = new long[2][n+1];
        IntStream.rangeClosed(0, 1).forEach(isPunished -> Arrays.fill(dp[isPunished], INF));
        for (int i = n; i >= 0; i--) {
            dp[0][i] = (i == n) ? 0 : Math.min(dp[0][i], seq[i]+dp[1][i+1]);
            dp[1][i] = (i == n) ? 0 : Math.min(Math.min(dp[1][i], dp[0][i+1]), seq[i]+dp[1][i+1]);
        }
        System.out.println(Math.min(dp[0][1], seq[0] + dp[1][1]));
    }
}