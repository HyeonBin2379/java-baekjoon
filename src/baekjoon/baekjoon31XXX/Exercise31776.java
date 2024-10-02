package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int[] solved = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = (int) Arrays.stream(solved).filter(value -> value == -1).count();

            if (count == 3) {
                continue;
            }
            switch (count) {
                case 0 -> {
                    if (solved[0] > -1 && solved[0] <= solved[1] && solved[1] <= solved[2]) {
                        answer++;
                    }
                }
                case 1 -> {
                    if (solved[0] > -1 && solved[0] <= solved[1] && solved[2] == -1) {
                        answer++;
                    }
                }
                case 2 -> {
                    if (solved[0] > -1 && solved[1] == -1 && solved[2] == -1) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
