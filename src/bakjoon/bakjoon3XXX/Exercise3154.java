package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3154 {

    private static final int[][] effort = {
            {0, 4, 3, 4, 3, 2, 3, 2, 1, 2},
            {4, 0, 1, 2, 1, 2, 3, 2, 3, 4},
            {3, 1, 0, 1, 2, 1, 2, 3, 2, 3},
            {4, 2, 1, 0, 3, 2, 1, 4, 3, 2},
            {3, 1, 2, 3, 0, 1, 2, 1, 2, 3},
            {2, 2, 1, 2, 1, 0, 1, 2, 1, 2},
            {3, 3, 2, 1, 2, 1, 0, 3, 2, 1},
            {2, 2, 3, 4, 1, 2, 3, 0, 1, 2},
            {1, 3, 2, 3, 2, 1, 2, 1, 0, 1},
            {2, 4, 3, 2, 3, 2, 1, 2, 1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;
        int hour = 0, minute = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i % 24 != time[0] || j % 60 != time[1]) {
                    continue;
                }
                int sum = effort[i/10][i%10] + effort[i%10][j/10] + effort[j/10][j%10];
                if (min > sum) {
                    min = sum;
                    hour = i;
                    minute = j;
                }
            }
        }
        System.out.printf("%02d:%02d\n", hour, minute);
    }
}
