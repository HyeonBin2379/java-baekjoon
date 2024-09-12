package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12715 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());
            long Z = Long.parseLong(st.nextToken());

            long[] A = new long[m];
            for (int i = 0; i < m; i++) {
                A[i] = Long.parseLong(br.readLine().trim());
            }

            long[] sequence = new long[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = A[i % m];
                A[i % m] = (X * A[i % m] + Y * (i + 1)) % Z;
            }

            long result = countIncreasingSubsequences(sequence);
            System.out.printf("Case #%d: %d%n", t, result);
        }
    }

    private static long countIncreasingSubsequences(long[] sequence) {
        int n = sequence.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1); // 각 원소 자체를 포함한 부분 수열 개수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
        }

        long total = 0;
        for (long count : dp) {
            total = (total + count) % MOD;
        }
        return (total + MOD) % MOD; // 빈 부분 수열 제외
    }
}
