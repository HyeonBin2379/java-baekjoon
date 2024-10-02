package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w_yard = sc.nextInt();
        int h_yard = sc.nextInt();
        int acre = (w_yard * h_yard) / 4840;
        System.out.println((acre / 5) + 1);
    }
}
