package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise5533 {

    private static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        score = new int[3][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                score[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] player = new int[n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                if (isDuplicated(score[i][j], i)) {
                    continue;
                }
                player[j] += score[i][j];
            }
        }
        Arrays.stream(player).forEach(System.out::println);
    }

    private static boolean isDuplicated(int num, int round) {
        int count = (int) Arrays.stream(score[round]).filter(value -> value == num).count();
        return count != 1;
    }
}