package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Exercise2630 {
    private static int[][] paper;
    private static int blueCount = 0;
    private static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        paper = new int[size][size];

        for (int i = 0; i < size; i++) {
            paper[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        partition(0, 0, size);
        System.out.println(whiteCount+"\n"+blueCount);
    }

    public static void partition(int row, int col, int size) {
        if (isAllColorSame(row, col, size)) {
            if (paper[row][col] == 1) {
                blueCount++;
            }
            else {
                whiteCount++;
            }
            return;
        }

        int half = size / 2;
        partition(row, col, half);
        partition(row, col+half, half);
        partition(row+half, col, half);
        partition(row+half, col+half, half);
    }
    private static boolean isAllColorSame(int row, int col, int size) {
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (paper[row][col] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
