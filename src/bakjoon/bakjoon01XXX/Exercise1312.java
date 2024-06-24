package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int remainder = a % b;
        for (int i = 0; i < n-1; i++) {
            remainder *= 10;
            remainder %= b;
        }

        System.out.println(remainder*10/b);
        sc.close();
    }
}
