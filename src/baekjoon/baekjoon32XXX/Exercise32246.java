package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32246 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n > 2 ? n : 2*n-1);
    }
}