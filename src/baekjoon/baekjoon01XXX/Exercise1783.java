package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1783 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        switch (n) {
            case 1 -> System.out.println(1);
            case 2 -> System.out.println(Math.min((m+1)/2, 4));
            default -> System.out.println(m < 7 ? Math.min(m, 4) : m - 2);
        }
    }
}
