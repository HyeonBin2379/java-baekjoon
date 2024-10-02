package baekjoon.baekjoon17XXX;

import java.util.Scanner;

public class Exercise17358 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong()-1;
        long answer = 1;
        for (long i = n; i >= 1; i -= 2) {
            answer *= i;
            answer %= MOD;
        }
        System.out.println(answer);
    }
}
