package programmers;

import java.util.Arrays;

class QuadCompressionSolution {
    private int zero, one;
    private int[][] input;

    public int[] solution(int[][] arr) {
        input = arr;
        partition(0, 0, input.length);
        return new int[] {zero, one};
    }

    public boolean isSameValue(int row, int col, int size) {
        int value = input[row][col];
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (value != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void partition(int row, int col, int size) {
        if (isSameValue(row, col, size)) {
            if (input[row][col] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }

        int half = size / 2;
        partition(row, col, half);
        partition(row, col+half, half);
        partition(row+half, col, half);
        partition(row+half, col+half, half);
    }
}
public class QuadCompression {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(Arrays.toString(new QuadCompressionSolution().solution(arr)));
    }
}
