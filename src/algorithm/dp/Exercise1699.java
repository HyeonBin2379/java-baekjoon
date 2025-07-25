package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = IntStream.rangeClosed(0, n).toArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= n; j++) {
                if (i-j*j >= 0) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
