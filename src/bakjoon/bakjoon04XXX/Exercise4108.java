package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4108 {

    private static int r, c;
    private static char[][] mineField;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0) {
                break;
            }

            mineField = new char[r][c];
            for (int i = 0; i < r; i++) {
                mineField[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (mineField[i][j] == '*') {
                        sb.append('*');
                    } else {
                        sb.append(countMine(i, j));
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int countMine(int row, int col) {
        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {1, 1, 1, 0, -1, -1, -1, 0};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = col + x[i];
            int ny = row + y[i];

            if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                if (mineField[ny][nx] == '*') {
                    count++;
                }
            }
        }
        return count;
    }
}
