package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2583 {

    private static int[][] colored;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        colored = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lc = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken());
            int rr = Integer.parseInt(st.nextToken());

            for (int y = lr; y < rr; y++) {
                for (int x = lc; x < rc; x++) {
                    colored[y][x] = -1;
                }
            }
        }
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (colored[y][x] == 0) {
                    int count = bfs(y, x);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        result.stream().sorted().forEach(area -> System.out.print(area + " "));
    }

    private static int bfs(int startR, int startC) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startR, startC});
        colored[startR][startC] = 1;

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (colored[nr][nc] == 0) {
                    colored[nr][nc] = 1;
                    ++count;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        return count;
    }
}
