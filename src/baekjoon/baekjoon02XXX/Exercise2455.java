package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0, now = 0;
        for (int i = 0; i < 4; i++) {
            now -= sc.nextInt();
            max = Math.max(max, now);
            now += sc.nextInt();
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}
