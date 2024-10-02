package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1236 {

    private static String[] castle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        castle = new String[n];
        for (int i = 0; i < n; i++) {
            castle[i] = br.readLine();
        }

        int row_count = 0, col_count = 0;
        for (int i = 0; i < n; i++) {
            if (!castle[i].contains("X")) {
                row_count++;
            }
        }
        for (int i = 0; i < m; i++) {
            if (isNotInCol(i, n)) {
                col_count++;
            }
        }
        System.out.println(Math.max(row_count, col_count));
    }

    public static boolean isNotInCol(int col, int rowLen) {
        for (int i = 0; i < rowLen; i++) {
            if (castle[i].charAt(col) == 'X') {
                return false;
            }
        }
        return true;
    }
}
