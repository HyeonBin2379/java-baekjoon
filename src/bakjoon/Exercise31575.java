package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise31575 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[][] move = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[m][n];
        bfs();
        System.out.println(visited[m-1][n-1] ? "Yes" : "No");
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Integer[] {0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
    }
}
