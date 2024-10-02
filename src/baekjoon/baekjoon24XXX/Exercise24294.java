package baekjoon.baekjoon24XXX;

import java.util.Scanner;

public class Exercise24294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w1 = sc.nextLong();
        long h1 = sc.nextLong();
        long w2 = sc.nextLong();
        long h2 = sc.nextLong();
        sc.close();
        System.out.println((Math.max(w1, w2) + h1+h2)*2 + 4);
    }
}
