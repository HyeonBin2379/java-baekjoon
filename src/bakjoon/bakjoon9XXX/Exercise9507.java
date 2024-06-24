package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9507 {

    private static final long[] dp = new long[68];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        setAnswer();
        for (int i = 0; i < testCase; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }

    private static void setAnswer() {
        for (int i = 0; i < 68; i++) {
            if (i < 2) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 4;
            } else {
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
            }
        }
    }
}
