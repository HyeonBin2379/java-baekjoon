package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] fibo = new long[n+1];
        for (int i = 1; i <= n; i++) {
            fibo[i] = (i == 1) ? 1 : fibo[i-1]+fibo[i-2];
        }
        System.out.println(fibo[n]);
    }
}
