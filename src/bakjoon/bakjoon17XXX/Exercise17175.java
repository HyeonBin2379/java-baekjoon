package bakjoon.bakjoon17XXX;

import java.util.Scanner;

public class Exercise17175 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fib = new int[n+1];

        for (int i = 0; i < fib.length; i++) {
            fib[i] = (i < 2) ? 1 : (fib[i-2]+fib[i-1]+1) % MOD;
        }
        System.out.println(fib[n]);
    }
}
