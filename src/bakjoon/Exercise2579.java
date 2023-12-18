package bakjoon;

import java.util.Scanner;

public class Exercise2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        int[] stairs = new int[height + 1];
        int[] score = new int[height + 1];
        for (int i = 1; i < height+1; i++) {
            stairs[i] = sc.nextInt();
        }

        for (int i = 1; i < height+1; i++) {
            if (i == 1) {
                score[i] = stairs[i];
            } else if (i == 2) {
                score[i] = Math.max(score[i-2], score[i-1]) + stairs[i];
            } else {
                score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
            }
        }
        System.out.println(score[height]);
    }
}
