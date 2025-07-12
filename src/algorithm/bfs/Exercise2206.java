package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2206 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int m, n;
    private static int[][] grid;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        queue.offer(new Integer[]{0, 0, 0, 1});

        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int wallBrokenCnt = curr[2];
            int dist = curr[3];

            if (curr[0] == n-1 && curr[1] == m-1) {
                System.out.println(dist);
                return;
            }

            for (int[] next : moves) {
                int nr = curr[0]+next[0];
                int nc = curr[1]+next[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (grid[nr][nc] == 0 && !visited[nr][nc][wallBrokenCnt]) {
                    visited[nr][nc][wallBrokenCnt] = true;
                    queue.offer(new Integer[]{nr, nc, wallBrokenCnt, dist+1});
                } else if (grid[nr][nc] == 1 && wallBrokenCnt == 0 && !visited[nr][nc][wallBrokenCnt]) {
                    visited[nr][nc][1] = true;
                    queue.offer(new Integer[]{nr, nc, 1, dist+1});
                }
            }
        }
        System.out.println(-1);
    }
}
