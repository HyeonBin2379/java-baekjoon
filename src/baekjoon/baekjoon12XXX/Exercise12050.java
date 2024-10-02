package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise12050 {

    private static int n, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            grid = new int[n][m];
            for (int j = 0; j < grid.length; j++) {
                grid[j] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            sb.append(String.format("Case #%d:\n", i));
            int q = Integer.parseInt(br.readLine());
            for (int j = 0; j < q; j++) {
                String[] cmd = br.readLine().split(" ");
                switch (cmd[0]) {
                    case "M" -> {
                        int row = Integer.parseInt(cmd[1]);
                        int col = Integer.parseInt(cmd[2]);
                        grid[row][col] = Integer.parseInt(cmd[3]);
                    }
                    case "Q" -> {
                        visited = new boolean[n][m];
                        int count = 0;
                        for (int r = 0; r < n; r++) {
                            for (int c = 0; c < m; c++) {
                                if (!visited[r][c] && grid[r][c] == 1) {
                                    bfs(r, c);
                                    count++;
                                }
                            }
                        }
                        sb.append(count).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }

    private static void bfs(int startR, int startC) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startR][startC] = true;
        queue.add(new Integer[]{startR, startC});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
