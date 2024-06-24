package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0 0 0")) {
                break;
            }
            int[] score = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(score);
            int sum = Arrays.stream(score).sum() - score[0] - score[5];
            if (sum % 4 == 0) {
                sb.append(String.format("%d\n", sum / 4));
            } else {
                sb.append((sum % 2 == 1) ? String.format("%.2f\n", sum/4.0) : String.format("%.1f\n", sum/4.0));
            }
        }
        System.out.print(sb);
    }
}
