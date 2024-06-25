package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise9781 {

    private static int n, m;
    private static int[][] visited;
    private static char[][] board;
    private static final int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Integer[]> queue = new LinkedList<>();
        board = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'K') {
                    queue.add(new Integer[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        bfs(queue);
    }

    private static void bfs(Queue<Integer[]> queue) {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (board[now[0]][now[1]] == 'X') {
                System.out.println(visited[now[0]][now[1]]);
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == '#') {
                    continue;
                }
                if (visited[nr][nc] == -1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println(-1);
    }
}
