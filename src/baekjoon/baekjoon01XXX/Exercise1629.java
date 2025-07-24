package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1629 {

    private static int mod;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        mod = sc.nextInt();
        System.out.println(power(a, b));
    }

    private static long power(int base, int exp) {
        if (exp == 1) {
            return base % mod;
        }

        long k = power(base, exp/2) % mod;

        if (exp % 2 == 0) {
            return k*k % mod;
        } else {
            return k*k % mod * base % mod;
        }
    }
}
