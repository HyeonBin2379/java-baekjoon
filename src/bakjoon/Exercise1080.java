package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1080 {

    private static int[][] matrix1, matrix2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix1[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        matrix2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix2[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        if (n < 3 && m < 3 && !isSame(0, 0, n, m)) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    flopMatrix(i, j);
                    count++;
                }
            }
        }
        System.out.println(isSame(0, 0, n, m) ? count : -1);
    }

    private static void flopMatrix(int startRow, int startCol) {
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                matrix1[i][j] = (matrix1[i][j] == 1) ? 0 : 1;
            }
        }
    }

    private static boolean isSame(int startRow, int startCol, int rowLen, int colLen) {
        for (int i = startRow; i < rowLen; i++) {
            for (int j = startCol; j < colLen; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
