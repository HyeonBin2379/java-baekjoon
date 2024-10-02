package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26767 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i < num+1; i++) {
            if (i % 7 == 0) {
                System.out.println((i % 11 == 0) ? "Wiwat!" : "Hurra!");
            } else {
                System.out.println((i % 11 == 0) ? "Super!" : i);
            }
        }
    }
}
