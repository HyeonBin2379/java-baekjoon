package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15486 {

    private static final long[] dp = new long[1500001];
    private static final int[][] schedule = new int[1500000][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            schedule[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        setDP(n);
        System.out.println(dp[n]);
    }

    private static void setDP(int n) {
        for (int i = 0; i < n; i++) {
            int lastDay = i + schedule[i][0];
            dp[i+1] = Math.max(dp[i+1], dp[i]);
            if (lastDay <= n) {
                dp[lastDay] = Math.max(dp[lastDay], dp[i] + schedule[i][1]);
            }
        }
    }
}
