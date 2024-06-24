package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2580 {
    private static final int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row+1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (promising(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }
    public static boolean promising(int row, int col, int value) {
        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int[] ints : arr) {
            if (ints[col] == value) {
                return false;
            }
        }

        int sub_row = (row / 3) * 3;
        int sub_col = (col / 3) * 3;
        for (int i = sub_row; i < sub_row+3; i++) {
            for (int j = sub_col; j < sub_col+3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
