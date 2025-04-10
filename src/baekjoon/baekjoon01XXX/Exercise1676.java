package baekjoon.baekjoon01XXX;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger[] dp = new BigInteger[n+1];
        Arrays.fill(dp, BigInteger.ONE);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while (dp[n].remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
            dp[n] = dp[n].divide(BigInteger.TEN);
            count++;
        }
        System.out.println(count);
    }
}
