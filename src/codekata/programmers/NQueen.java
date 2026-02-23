package codekata.programmers;

import java.util.stream.IntStream;

public class NQueen {

    // queens[i] = j -> i행 j열에 퀸 배치
    private static int[] queens;
    private static int count;

    public int solution(int n) {
        queens = new int[n];
        backtracking(0, n);
        return count;
    }

    private static void backtracking(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            // 현재 행에서 queen을 배치할 열을 선택
            queens[row] = col;
            if (isValid(row)) {
                backtracking(row+1, n);
            }
        }
    }

    private static boolean isValid(int rowNum) {
        return IntStream.range(0, rowNum)
                .noneMatch(i -> queens[i] == queens[rowNum] || Math.abs(rowNum-i) == Math.abs(queens[i]-queens[rowNum]));
    }

    public static void main(String[] args) {
        int n = 4;
        int result = new NQueen().solution(n);
        System.out.println(result);
    }
}
