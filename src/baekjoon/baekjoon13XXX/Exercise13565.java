package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise13565 {

    private static int m, n;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && graph[0][i] == 0 && canPercolate(i)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean canPercolate(int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][c] = true;
        queue.add(new int[] {0, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && graph[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
        return IntStream.rangeClosed(0, n-1).anyMatch(idx -> visited[m-1][idx]);
    }
}
