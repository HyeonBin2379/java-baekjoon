package bakjoon;

import java.util.Scanner;

public class Exercise1788 {
    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fib = new int[Math.abs(n)+1];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = (i < 2) ? i : fib[i-2] + fib[i-1];
            fib[i] %= MOD;
        }
        if (n % 2 == 0 && n < 0) {
            System.out.println(-1);
        } else if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
        System.out.println(fib[Math.abs(n)]);
    }
}
