package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[2];
        int[][] round = new int[2][10];

        for (int i = 0; i < 2; i++) {
            round[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 10; i++) {
            if (round[0][i] > round[1][i]) {
                score[0] += 3;
            } else if (round[0][i] < round[1][i]) {
                score[1] += 3;
            } else {
                score[0] += 1;
                score[1] += 1;
            }
        }

        System.out.println(score[0] + " " + score[1]);
        if (score[0] > score[1]) {
            System.out.println("A");
        } else if (score[0] < score[1]) {
            System.out.println("B");
        } else {
            for (int i = 9; i >= 0; i--) {
                if (round[0][i] != round[1][i]) {
                    System.out.println(round[0][i] > round[1][i] ? "A" : "B");
                    return;
                }
            }
            System.out.println("D");
        }
    }
}
