package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        long sum = 0;
        long[] dp = new long[num+1];
        for (int i = 2; i <= num; i += 2) {
            if (i == 2) {
                dp[i] = 3;
                continue;
            }
            dp[i] = 3 * dp[i-2] + (sum * 2 + 2);
            sum += dp[i-2];
        }
        System.out.println(dp[num]);
    }
}
