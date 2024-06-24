package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1996 {

    private static int size;
    private static char[][] mineField;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        mineField = new char[size][size];
        for (int i = 0; i < size; i++) {
            mineField[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Character.isDigit(mineField[i][j])) {
                    sb.append('*');
                } else {
                    sb.append(getCount(i, j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static char getCount(int r, int c) {
        int[] row = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] col = {-1, 0, 1, 1, 1, 0, -1, -1};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
                if (Character.isDigit(mineField[nr][nc])) {
                    count += mineField[nr][nc] - '0';
                }
            }
        }
        return (count >= 10) ? 'M' : (char)(count+'0');
    }
}
