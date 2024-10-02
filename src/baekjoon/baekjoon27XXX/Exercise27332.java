package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((a + b*7 > 30) ? 0 : 1);
    }
}
