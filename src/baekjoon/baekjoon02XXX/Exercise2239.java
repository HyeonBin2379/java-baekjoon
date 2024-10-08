package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2239 {

    private static final int[][] sudoku = new int[9][9];
    private static final List<Integer[]> blank = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            sudoku[i] = Arrays.stream(br.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    blank.add(new Integer[]{i, j});
                }
            }
        }
        backtracking(0);
    }

    private static boolean isPromising(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[r][i] == num && i != c) {
                return false;
            }
            if (sudoku[i][c] == num && i != r) {
                return false;
            }
            int nr = r/3*3 + i/3;
            int nc = c/3*3 + i%3;
            if (sudoku[nr][nc] == num && (nr != r || nc != c)) {
                return false;
            }
        }
        return true;
    }

    private static void backtracking(int index) {
        if (index == blank.size()) {
            for (int i = 0; i < 9; i++) {
                System.out.println(Arrays.stream(sudoku[i]).mapToObj(Integer::toString).collect(Collectors.joining()));
            }
            System.exit(0);
        }

        int r = blank.get(index)[0];
        int c = blank.get(index)[1];

        for (int k = 1; k <= 9; k++) {
            if (isPromising(r, c, k)) {
                sudoku[r][c] = k;
                backtracking(index+1);
                sudoku[r][c] = 0;
            }
        }
    }
}
