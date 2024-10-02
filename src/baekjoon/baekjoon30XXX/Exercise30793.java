package baekjoon.baekjoon30XXX;

import java.util.Scanner;

public class Exercise30793 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        double v = (double) p / r;
        if (v < 0.2) {
            System.out.println("weak");
        } else if (v < 0.4) {
            System.out.println("normal");
        } else if (v < 0.6) {
            System.out.println("strong");
        } else {
            System.out.println("very strong");
        }
    }
}
