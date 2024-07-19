package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise4677 {

    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int count = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == '@') {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == '@') {
                    visited[nr][nc] = true;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }
}
