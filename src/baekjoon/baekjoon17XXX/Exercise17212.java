package baekjoon.baekjoon17XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise17212 {

    private static final int INF = (int) 1e9;
    private static final int[] coin = {1, 2, 5, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = IntStream.rangeClosed(0, n).map(i -> (i == 0) ? 0 : INF).toArray();
        for (int k : coin) {
            for (int j = k; j <= n; j++) {
                dp[j] = Math.min(dp[j-k] + 1, dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
