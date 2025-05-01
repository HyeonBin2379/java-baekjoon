package algorithm.dp;

import java.util.Scanner;

public class Exercise9095 {

    private static final int[] dp = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        setNumbers();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
        sc.close();
    }

    private static void setNumbers() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
    }
}
