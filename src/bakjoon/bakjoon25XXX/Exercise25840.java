package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25840 {

    private static final int[] currency = {1, 5, 10, 20, 50, 100};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] score = new int[6];
        int max = 0, answer = 0;
        for (int i = 0; i < 6; i++) {
            score[i] = count[i]*currency[i];
            if (max < score[i]) {
                max = score[i];
                answer = i;
            } else if (max == score[i]) {
                answer = (count[i] < count[answer]) ? i : answer;
            }
        }
        System.out.println(currency[answer]);
    }
}
