package bakjoon.bakjoon17XXX;

import java.util.Scanner;

public class Exercise17520 {

    private static final int MOD = 16769023;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 2;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                sum = (sum * 2) % MOD;
            }
        }
        System.out.println(sum);
    }
}
