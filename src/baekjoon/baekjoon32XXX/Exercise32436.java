package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        int size = Integer.parseInt(br.readLine());
        int[][] original = new int[size][size];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            original[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                min = Math.min(original[i][j], min);
            }
        }
        br.close();

        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            rotated[i] = original[i].clone();
        }

        int answer;
        for (answer = 0; answer <= size; answer++) {
            if (rotated[0][0] == min) {
                break;
            }
            rotated = rotateOnce(rotated, size);
        }
        System.out.println(answer);
    }

    private static int[][] rotateOnce(int[][] matrix, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[size-j-1][i] = matrix[i][j];
            }
        }
        return result;
    }
}