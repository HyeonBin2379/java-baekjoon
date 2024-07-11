package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14716 {

    private static int m, n;
    private static boolean[][] visited;
    private static int[][] logo;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        logo = new int[m][n];
        for (int i = 0; i < m; i++) {
            logo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && logo[i][j] == 1) {
                    checkLetter(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void checkLetter(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && logo[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }
}
