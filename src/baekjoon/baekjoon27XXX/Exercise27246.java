package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27246 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long i;
        for (i = 1; i*i <= num; i++) {
            num -= i*i;
        }
        System.out.println(i-1);
    }
}
