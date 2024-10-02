package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        System.out.println((int)Math.ceil((double)a*b/12)*d);
    }
}
