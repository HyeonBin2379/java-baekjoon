package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1660 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prefixNum = new int[122];
        int[] triangle = new int[122];
        for (int i = 1; i < prefixNum.length; i++) {
            prefixNum[i] = prefixNum[i-1] + i;
            for (int j = 1; j <= i; j++) {
                triangle[i] += prefixNum[j];
            }
        }

        int[] dp = new int[300001];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int k : triangle) {
                if (i < k) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - k] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
