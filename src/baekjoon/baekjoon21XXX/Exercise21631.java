package baekjoon.baekjoon21XXX;

import java.util.Scanner;

public class Exercise21631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (a >= b) {
            System.out.println(b);
        } else if (b != 0) {
            System.out.println(a+1);
        } else {
            System.out.println(0);
        }
    }
}
