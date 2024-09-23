package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise31040 {

    private static final int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            List<Integer[]> knights = new ArrayList<>();
            board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == 'k') {
                        knights.add(new Integer[]{i, j});
                    }
                }
            }
            br.readLine();

            String answer = "valid";
            for (Integer[] pos : knights) {
                if (!isValid(pos[0], pos[1])) {
                    answer = "invalid";
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean isValid(int r, int c) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }
            if (board[nr][nc] == 'k') {
                return false;
            }
        }
        return true;
    }
}
