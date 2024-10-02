package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1245 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && isPeek(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isPeek(int r, int c) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        boolean result = true;
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m
                        || map[now[0]][now[1]] > map[nr][nc]) {
                    continue;
                }
                if (map[now[0]][now[1]] < map[nr][nc]) {
                    result = false;
                    continue;
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        return result;
    }
}
