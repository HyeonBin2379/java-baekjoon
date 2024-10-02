package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise17836 {

    private static int n, m, t, answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][m];
        answer = Integer.MAX_VALUE;
        bfs();
        System.out.println(answer > t ? "Fail" : answer);
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Integer[]{0, 0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (map[now[0]][now[1]] == 2) {
                answer = now[2] + (n-1-now[0]) + (m-1-now[1]);
                continue;
            }

            if (now[0] == n-1 && now[1] == m-1) {
                answer = Math.min(answer, now[2]);
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];
                int dist = now[2] + 1;

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] != 1) {
                    queue.offer(new Integer[]{nr, nc, dist});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
