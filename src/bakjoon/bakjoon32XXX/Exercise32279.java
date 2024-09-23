package bakjoon.bakjoon32XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise32279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int s = sc.nextInt();
        int a = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = a;
        for (int i = 2; i < n; i += 2) {
            dp[i] = p*dp[i/2] + q;
            dp[i+1] = r*dp[i/2] + s;
        }
        if (n % 2 == 0) {
            dp[n] = p*dp[n/2]+q;
        }
        System.out.println(Arrays.stream(dp).sum());
    }
}
