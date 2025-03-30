package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 2*n-1; i++) {
            if (i <= n) {
                System.out.print(" ".repeat(n-i));
                System.out.println("*".repeat(2*i-1));
            } else {
                System.out.print(" ".repeat(i-n));
                System.out.println("*".repeat((2*n-i)*2-1));
            }
        }
    }
}
