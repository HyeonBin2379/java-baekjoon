package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26547 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            int size = input.length;

            char[][] output = new char[size][size];
            for (int j = 0; j < size; j++) {
                Arrays.fill(output[j], ' ');
            }
            for (int j = 0; j < size; j++) {
                output[0][j] = input[j];
                output[j][0] = input[j];
                output[j][size-1] = input[size-1-j];
                output[size-1][j] = input[size-1-j];
            }
            for (int j = 0; j < size; j++) {
                sb.append(new String(output[j])).append("\n");
            }
        }
        System.out.print(sb);
    }
}
