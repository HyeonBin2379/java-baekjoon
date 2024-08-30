package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise6146 {

    private static int r;
    private static int c;
    private static final boolean[][] pool = new boolean[1001][1001];
    private static final int[][] visited = new int[1001][1001];

    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())+500;
        c = Integer.parseInt(st.nextToken())+500;
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) + 500;
            int col = Integer.parseInt(st.nextToken()) + 500;
            pool[row][col] = true;
        }

        IntStream.rangeClosed(0, 1000).forEach(i -> Arrays.fill(visited[i], -1));
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[500][500] = 0;
        queue.offer(new Integer[]{500, 500});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= 1001 || nc < 0 || nc >= 1001 || pool[nr][nc]) {
                    continue;
                }
                if (visited[nr][nc] == -1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println(visited[r][c]);
    }
}
