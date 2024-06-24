package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise23973 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer[]> candidate = new ArrayList<>();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    candidate.add(new Integer[] {i, j});
                }
            }
        }

        for (Integer[] now : candidate) {
            int[] score = new int[11];
            for (int i = Math.max(0, now[0]-9); i <= Math.min(n-1, now[0]+9); i++) {
                for (int j = Math.max(0, now[1]-9); j <= Math.min(m-1, now[1]+9); j++) {
                    if (board[i][j] == 1) {
                        int index = 10-Math.max(Math.abs(i-now[0]), Math.abs(j-now[1]));
                        score[index]++;
                    }
                }
            }
            if (IntStream.rangeClosed(1, 10).allMatch(index -> score[index] == 1)) {
                System.out.println(now[0] + " " + now[1]);
                return;
            }
        }
        System.out.println(-1);
    }
}
