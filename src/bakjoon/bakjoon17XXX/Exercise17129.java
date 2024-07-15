package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17129 {

    private static int n, m;
    private static int[][] map, visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        IntStream.rangeClosed(0, n-1).forEach(i -> Arrays.fill(visited[i], -1));
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Integer[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] != -1) {
                    continue;
                }
                if (map[nr][nc] != 1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.offer(new Integer[]{nr, nc});
                    if (map[nr][nc] > 2) {
                        answer = Math.min(visited[nr][nc], answer);
                    }
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? "NIE" : "TAK\n" + answer);
    }
}
