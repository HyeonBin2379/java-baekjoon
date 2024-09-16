package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12037 {

    private static final int MOD = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] dp = new int[l+1];
            dp[0] = 1;
            for (int j = 1; j <= l; j++) {
                dp[j] += dp[j-1]*v % MOD;
                if (j >= 2) {
                    dp[j] = (dp[j] + dp[j-2]*c*v) % MOD;
                    dp[j] %= MOD;
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, dp[l]));
        }
        System.out.print(sb);
    }
}
