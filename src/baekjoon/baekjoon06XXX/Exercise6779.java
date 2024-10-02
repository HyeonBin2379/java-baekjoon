package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= M; i++) {
            int a = (int) ((-6)*Math.pow(i, 4) + h*Math.pow(i, 3) + 2*Math.pow(i, 2) + i);
            if (a <= 0) {
                System.out.println("The balloon first touches ground at hour: " + i);
                return;
            }
        }
        System.out.println("The balloon does not touch ground in the given time.");
    }
}
