package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26169 {

    private static final int[][] board = new int[5][5];
    private static final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        dfs(startR, startC, 0, 0);
        System.out.println(found ? 1 : 0);
    }

    private static void dfs(int startR, int startC, int moves, int apples) {
        if (moves > 3) {
            return;
        }
        int original = board[startR][startC];
        if (original == 1) {
            apples++;
        }
        if (apples >= 2) {
            found = true;
            return;
        }

        board[startR][startC] = -1;
        for (int i = 0; i < 4; i++) {
            int nr = startR + move[i][0];
            int nc = startC + move[i][1];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && board[nr][nc] != -1) {
                dfs(nr, nc, moves + 1, apples);
                if (found) {
                    return;
                }
            }
        }
        board[startR][startC] = original;
    }
}
