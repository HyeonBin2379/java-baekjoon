package algorithm.recursive;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise2448 {

    private static char[][] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = new char[n][2*n-1];
        IntStream.range(0, n).forEach(idx -> Arrays.fill(result[idx], ' '));
        recursive(0, n-1, n);

        IntStream.range(0, n).mapToObj(idx -> new String(result[idx])).forEach(System.out::println);
    }

    private static void recursive(int row, int col, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                Arrays.fill(result[row+i], col-i, col+i+1, '*');
            }
            result[row+1][col] = ' ';
            return;
        }
        int half = size/2;
        recursive(row, col, half);
        recursive(row+half, col-half, half);
        recursive(row+half, col+half, half);
    }
}
