package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise5958 {

    private static int n;
    private static char[][] map;
    private static final int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    bfs(i, j, ++count);
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int r, int c, int count) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        map[r][c] = (char)('0'+count);
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (map[nr][nc] == '*') {
                    map[nr][nc] = (char) (count + '0');
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }
}
