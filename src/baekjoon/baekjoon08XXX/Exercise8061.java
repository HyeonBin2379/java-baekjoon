package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise8061 {

    private static int n, m;
    private static int[][] bitmap;
    private static boolean[][] visited;

    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bitmap = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            bitmap[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (bitmap[i][j] == 1) {
                    queue.offer(new Integer[]{i, j, 1});
                    bitmap[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Arrays.stream(bitmap[i])
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" ")))
                    .append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];
                int dist = now[2] + 1;

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && bitmap[nr][nc] == 0) {
                    queue.add(new Integer[]{nr, nc, dist});
                    bitmap[nr][nc] = now[2];
                    visited[nr][nc] = true;
                }
            }
        }
    }
}