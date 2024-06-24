package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int sum = Arrays.stream(score).sum();
        if (sum >= 100) {
            System.out.println("OK");
            return;
        }

        int min_index = -1;
        int min = 101;
        for (int i = 0; i < score.length; i++) {
            if (score[i] < min) {
                min = score[i];
                min_index = i;
            }
        }
        switch (min_index) {
            case 0 -> System.out.println("Soongsil");
            case 1 -> System.out.println("Korea");
            case 2 -> System.out.println("Hanyang");
        }
    }
}
