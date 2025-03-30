package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (b+c >= 60) {
            a = ((b+c)/60 + a) % 24;
            b = (b+c) % 60;
        } else {
            b += c;
        }
        System.out.println(a + " " + b);
    }
}
