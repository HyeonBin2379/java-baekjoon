package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int m = Integer.parseInt(sc.nextLine().trim());

        System.out.println(Math.min(n, m)*2 + Math.abs(n-m) % 2);
    }
}
