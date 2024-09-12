package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise11370 {

    private static int w, h;
    private static char[][] map;
    private static Queue<Integer[]> queue;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new char[h][w];
            queue = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 'S') {
                        queue.offer(new Integer[]{i, j});
                    }
                }
            }
            bfs();
            for (int i = 0; i < h; i++) {
                sb.append(new String(map[i])).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    continue;
                }
                if (map[nr][nc] == 'T') {
                    map[nr][nc] = 'S';
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }
}
