package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32184 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a % 2 == b % 2) {
            System.out.println((b-a+1)/2 + 1);
        } else {
            System.out.println(a % 2 == 1 ? (b-a+1)/2 : (b-a+1)/2+1);
        }
    }
}
