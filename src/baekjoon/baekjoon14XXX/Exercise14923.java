package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14923 {

    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int n, m;
    private static int[][] map, distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)-1).toArray();
        int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)-1).toArray();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        distance = new int[n][m];
        bfs(start, end);
    }

    private static void bfs(int[] start, int[] dest) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][n][m];
        queue.offer(new Integer[]{start[0], start[1], 1});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0] == dest[0] && now[1] == dest[1]) {
                System.out.println(distance[now[0]][now[1]]);
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || (map[nr][nc] == 1 && now[2] == 0)) {
                    continue;
                }
                if (!visited[now[2]][nr][nc]) {
                    int boom = (map[nr][nc] == 1 && now[2] == 1) ? 0 : now[2];
                    visited[now[2]][nr][nc] = true;
                    distance[nr][nc] = distance[now[0]][now[1]]+1;
                    queue.offer(new Integer[]{nr, nc, boom});
                }
            }
        }
        System.out.println(-1);
    }
}
