package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise15240 {

    private static int n, m;
    private static int[][] map, result;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            result[i] = map[i].clone();
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int newColor = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        bfs(r, c, map[r][c], newColor);
        for (int[] row : result) {
            System.out.println(Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining("")));
        }
    }

    private static void bfs(int r, int c, int before, int newColor) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        result[r][c] = newColor;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == before) {
                    visited[nr][nc] = true;
                    result[nr][nc] = newColor;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }
}
