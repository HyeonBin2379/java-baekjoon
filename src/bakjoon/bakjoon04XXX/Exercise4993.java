package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise4993 {

    private static int w, h;
    private static char[][] map;
    private static boolean[][] visited;

    private static final Queue<Integer[]> queue = new ArrayDeque<>();
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new char[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        visited[i][j] = true;
                        queue.offer(new Integer[]{i, j});
                    }
                }
            }
            bfs();
        }
    }

    private static void bfs() {
        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    count++;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println(count);
    }
}
