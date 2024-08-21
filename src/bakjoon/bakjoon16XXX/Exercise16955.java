package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise16955 {

    private static final char[][] board = new char[10][10];
    private static final int[][] move = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer[]> xPos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'X') {
                    xPos.add(new Integer[]{i, j});
                }
            }
        }
        for (Integer[] pos : xPos) {
            if (canWin(pos[0], pos[1])) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean canWin(int r, int c) {
        for (int[] ints : move) {
            int xCount = 1;
            int empty = 0;
            int nr = r, nc = c;

            for (int step = 0; step < 4; step++) {
                nr += ints[0];
                nc += ints[1];

                if (nr < 0 || nr >= 10 || nc < 0 || nc >= 10) {
                    continue;
                }
                switch (board[nr][nc]) {
                    case 'X' -> xCount++;
                    case '.' -> empty++;
                }
            }
            if (xCount == 4 && empty == 1) {
                return true;
            }
        }
        return false;
    }
}
