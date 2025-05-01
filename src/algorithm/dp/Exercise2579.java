package algorithm.dp;

import java.util.Scanner;

public class Exercise2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stairs = new int[n+1];
        int total = 0;
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
            total += stairs[i];
        }

        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = (i <= 3) ? stairs[i] : Math.min(dp[i-2], dp[i-3])+stairs[i];
        }
        System.out.println(n == 1 ? total : total-Math.min(dp[n-1], dp[n-2]));
    }
}
