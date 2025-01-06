package baekjoon.baekjoon33XXX;

import java.util.Scanner;

public class Exercise33046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] turn = new int[4];
        int jwa = (a+b) % 4 == 0 ? 4 : (a+b) % 4;
        for (int i = 1; i <= 4; i++) {
            turn[i % 4] = jwa+(i-1) <= 4 ? jwa+(i-1) : (jwa+i-1) % 4;
        }
        System.out.println(turn[(c+d) % 4]);
    }
}
