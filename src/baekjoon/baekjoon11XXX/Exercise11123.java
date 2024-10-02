package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise11123 {

    private static int n, m;
    private static char[][] pasture;
    private static boolean[][] visited;
    private static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            pasture = new char[n][m];
            for (int i = 0; i < n; i++) {
                pasture[i] = br.readLine().toCharArray();
            }

            visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && pasture[i][j] == '#') {
                        countSheep(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void countSheep(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : MOVE) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) {
                    continue;
                }
                if (pasture[nr][nc] == '#') {
                    visited[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
