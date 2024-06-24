package bakjoon.bakjoon09XXX;

import java.util.Scanner;

public class Exercise9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int number = sc.nextInt();
            Long[] dp = new Long[number+1];
            dp[0] = 0L;
            for (int j = 1; j < number+1; j++) {
                if (j < 4) {
                    dp[j] = 1L;
                } else {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
            }
            sb.append(dp[number]).append("\n");
        }
        System.out.print(sb);
    }
}
