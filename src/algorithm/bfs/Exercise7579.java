package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise7579 {

    private static final int[][] moves = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};
    private static final Queue<Integer[]> queue = new ArrayDeque<>();

    private static int m, n, h, notRipened;
    private static int[][][] boxes, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        boxes = new int[h][n][m];
        dist = new int[h][n][m];
        notRipened = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                boxes[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.fill(dist[i][j], -1);
                for (int k = 0; k < m; k++) {
                    if (boxes[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        queue.offer(new Integer[]{i, j, k});
                    } else if (boxes[i][j][k] == 0) {
                        notRipened++;
                    }
                }
            }
        }

        if (notRipened == 0) {
            System.out.println(0);
            return;
        }
        bfs();
    }

    private static void bfs() {
        int lastDist = 0;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            lastDist = dist[now[0]][now[1]][now[2]];

            for (int[] move : moves) {
                Integer[] next = IntStream.range(0, 3).map(idx -> now[idx]+move[idx]).boxed().toArray(Integer[]::new);

                if (next[0] < 0 || next[0] >= h
                        || next[1] < 0 || next[1] >= n
                        || next[2] < 0 || next[2] >= m) {
                    continue;
                }
                if (dist[next[0]][next[1]][next[2]] == -1 && boxes[next[0]][next[1]][next[2]] == 0) {
                    dist[next[0]][next[1]][next[2]] = dist[now[0]][now[1]][now[2]]+1;
                    queue.offer(next);
                    notRipened--;
                }
            }
        }

        if (notRipened != 0) {
            System.out.println(-1);
        } else {
            System.out.println(lastDist);
        }
    }
}
