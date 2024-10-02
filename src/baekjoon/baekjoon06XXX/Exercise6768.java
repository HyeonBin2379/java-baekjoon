package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6768 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goalScorer = sc.nextInt();
        int count = 0;
        for (int a = 1; a <= goalScorer-3; a++) {
            for (int b = a+1; b <= goalScorer-2; b++) {
                for (int c = b+1; c <= goalScorer-1; c++) {
                    if (a < b && b < c) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
