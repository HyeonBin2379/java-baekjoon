package bakjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2448 {
    private static char[][] result;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], ' ');
        }
        sc.close();

        star(0, n-1, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char[] row : result) {
            for (char pixel : row) {
                bw.write(pixel);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int row, int col, int size) {
        if (size == 3) {
            result[row][col] = result[row+2][col] = '*';
            result[row+1][col-1] = result[row+1][col+1] = '*';
            result[row+2][col-1] = result[row+2][col+1] = '*';
            result[row+2][col-2] = result[row+2][col+2] = '*';
            return;
        }

        int half = size/2;
        star(row, col, half);
        star(row+half, col-half, half);
        star(row+half, col+half, half);
    }
}
