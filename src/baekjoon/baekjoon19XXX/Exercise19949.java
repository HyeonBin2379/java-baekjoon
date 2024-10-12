package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise19949 {

    private static int count;
    private static int[] answer;
    private static final int[] selected = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backtracking(0, 0);
        System.out.println(count);
    }

    private static void backtracking(int depth, int score) {
        if (depth == 10) {
            count += (score >= 5) ? 1 : 0;
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && selected[depth-1] == i && selected[depth-2] == i) {
                continue;
            }
            selected[depth] = i;
            if (answer[depth] == i) {
                backtracking(depth+1, score+1);
            } else {
                backtracking(depth+1, score);
            }
        }
    }
}
