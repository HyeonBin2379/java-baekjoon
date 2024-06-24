package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise15992 {

    private static final long MOD = 1000000009;
    private static final long[][] dp = new long[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        calculate();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(dp[n][m] + "\n");
        }
        br.close();
        bw.close();
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
