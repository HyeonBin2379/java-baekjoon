package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0 -> dp[0] = wine[0];
                case 1 -> dp[1] = dp[0] + wine[1];
                case 2 -> dp[2] = Math.max(Math.max(wine[2] + wine[1], wine[2] + wine[0]), dp[1]);
                default ->
                        dp[i] = Math.max(Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]), dp[i - 1]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
