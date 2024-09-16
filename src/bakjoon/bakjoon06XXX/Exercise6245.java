package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise6245 {

    private static int n;
    private static int[][] score, dp;
    private static final int[][] MOVE = {{-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                char num = token[j].charAt(0);
                switch (num) {
                    case 'A' -> score[i][j] = 1;
                    case 'T' -> score[i][j] = 10;
                    case 'J' -> score[i][j] = 11;
                    case 'Q' -> score[i][j] = 12;
                    case 'K' -> score[i][j] = 13;
                    default -> score[i][j] = num - '0';
                }
            }
        }

        dp = new int[n][n];
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new ArrayDeque<>();
        dp[n-1][0] = score[n-1][0];
        queue.offer(new Integer[]{n-1, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nr = now[0] + MOVE[i][0];
                int nc = now[1] + MOVE[i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                dp[nr][nc] = Math.max(dp[nr][nc], dp[now[0]][now[1]]+score[nr][nc]);
                queue.offer(new Integer[]{nr, nc});
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
