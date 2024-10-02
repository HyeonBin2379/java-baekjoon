package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] total = new int[5];
        int winner = 0, max = 0;
        for (int i = 0; i < 5; i++) {
            int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            total[i] = Arrays.stream(score).sum();
            if (max < total[i]) {
                winner = i+1;
                max = total[i];
            }
        }
        System.out.println(winner + " " + total[winner-1]);
    }
}
