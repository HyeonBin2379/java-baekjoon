package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32710 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 10) {
            System.out.println(1);
            return;
        }
        for (int i = 2; i <= 9; i++) {
            if (num % i == 0 && num/i < 10) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
