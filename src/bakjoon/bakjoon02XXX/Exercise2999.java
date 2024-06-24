package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] received = br.readLine().toCharArray();
        int row = getRowLen(received.length);
        int col = received.length / row;

        char[][] matrix = new char[col][row];
        for (int i = 0; i < received.length; i++) {
            matrix[i/row][i % row] = received[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(matrix[j][i]);
            }
        }
        System.out.println(sb);
    }

    private static int getRowLen(int strLen) {
        int row = 0;
        for (int i = 1; i*i <= strLen; i++) {
            if (strLen % i == 0) {
                row = Math.max(i, row);
            }
        }
        return row;
    }
}
