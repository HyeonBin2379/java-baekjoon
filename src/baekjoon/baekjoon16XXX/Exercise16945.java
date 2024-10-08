package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise16945 {

    private static int answer = Integer.MAX_VALUE;
    private static final int[][] magicSqr = new int[3][3];
    private static final boolean[] checked = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            magicSqr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int totalCost) {
        if (depth == 9 && isPromise()) {
            answer = Math.min(totalCost, answer);
            return;
        }

        int row = depth / 3;
        int col = depth % 3;
        for (int num = 1; num <= 9; num++) {
            if (!checked[num-1]) {
                int temp = magicSqr[row][col];
                checked[num-1] = true;
                magicSqr[row][col] = num;
                backtracking(depth+1, totalCost + Math.abs(temp-num));
                checked[num-1] = false;
                magicSqr[row][col] = temp;
            }
        }
    }

    private static boolean isPromise() {
        if (IntStream.range(0, 3)
                .map(idx -> Arrays.stream(magicSqr[idx]).sum())
                .anyMatch(sum -> sum != 15)) {
            return false;
        }
        if (IntStream.range(0, 3)
                .map(idx -> magicSqr[0][idx] + magicSqr[1][idx] + magicSqr[2][idx])
                .anyMatch(sum -> sum != 15)) {
            return false;
        }
        int[] dSum = new int[2];
        for (int i = 0; i < 3; i++) {
            dSum[0] += magicSqr[i][i];
            dSum[1] += magicSqr[2-i][i];
        }
        return dSum[0] == 15 && dSum[1] == 15;
    }
}
