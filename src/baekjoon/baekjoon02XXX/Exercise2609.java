package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = getGCD(a, b);

        System.out.println(gcd);
        System.out.println(a*b/gcd);
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
