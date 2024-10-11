package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise12887 {

    private static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Queue<Integer[]> queue = new ArrayDeque<>();

    private static int n, min;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[2][n];

        int white = 0;
        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    if (j == 0) {
                        queue.offer(new Integer[]{i, j, 1});
                        map[i][j] = '#';
                    }
                    white++;
                }
            }
        }
        bfs();
        System.out.println(white-min);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[1] == n-1) {
                min = now[2];
                break;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= 2 || nc < 0 || nc >= n) {
                    continue;
                }
                if (map[nr][nc] == '.') {
                    map[nr][nc] = '#';
                    queue.offer(new Integer[]{nr, nc, now[2]+1});
                }
            }
        }
    }
}
