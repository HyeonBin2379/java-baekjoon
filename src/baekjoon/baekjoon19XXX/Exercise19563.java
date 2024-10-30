package baekjoon.baekjoon19XXX;

import java.util.Scanner;

public class Exercise19563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Math.abs(sc.nextInt());
        int b = Math.abs(sc.nextInt());
        int n = sc.nextInt();

        int diff = (a+b)-n;
        System.out.println(diff <= 0 && diff % 2 == 0 ? "YES" : "NO");
    }
}
