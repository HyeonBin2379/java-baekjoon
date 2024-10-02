package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println((n < 8) ? m+7 : n-7);
    }
}
