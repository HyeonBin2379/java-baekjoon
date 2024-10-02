package baekjoon.baekjoon31XXX;

import java.util.Scanner;

public class Exercise31261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println((int) Math.pow(a, 2)*(a+b+1));
    }
}
