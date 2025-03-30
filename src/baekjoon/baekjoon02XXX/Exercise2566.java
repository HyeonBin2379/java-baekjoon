package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int maxNum = 0;
        int row = 1, col = 1;
        for (int i = 0; i < 9; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                if (maxNum < arr[i][j]) {
                    maxNum = arr[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println(row + " " + col);
    }
}
