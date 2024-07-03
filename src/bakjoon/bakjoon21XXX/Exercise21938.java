package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise21938 {

    private static int n, m;
    private static int[][] pixel;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pixel = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 3*m; j += 3) {
                pixel[i][j/3] = IntStream.rangeClosed(j, j + 2).map(idx -> temp[idx]).reduce(0, Integer::sum) / 3;
            }
        }
        int t = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(0, n*m-1).forEach(i -> pixel[i/m][i%m] = pixel[i/m][i%m] < t ? 0 : 255);

        int totalCnt = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && pixel[i][j] == 255) {
                    bfs(i, j);
                    totalCnt++;
                }
            }
        }
        System.out.println(totalCnt);
    }

    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && pixel[nr][nc] == 255) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
