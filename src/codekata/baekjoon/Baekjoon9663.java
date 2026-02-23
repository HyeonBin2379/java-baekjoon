package codekata.baekjoon;

import java.util.Scanner;

public class Baekjoon9663 {

    // queens[i] = j -> i행 j열에 퀸 배치
    private static int[] queens;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queens = new int[n];
        backtracking(0, n);
        System.out.println(count);
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
        for (int i = 0; i < rowNum; i++) {
            // 동일한 열에 위치한 queen이 이미 존재하거나, 동일한 대각선상에 배치된 queen이 이미 존재하는지 확인
            if (queens[i] == queens[rowNum]
                    || Math.abs(rowNum-i) == Math.abs(queens[i]-queens[rowNum])) {
                return false;
            }
        }
        return true;
    }
}
