package baekjoon.baekjoon24XXX;

import java.util.Scanner;

public class Exercise24075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Math.max(a+b, a-b));
        System.out.println(Math.min(a+b, a-b));
    }
}
