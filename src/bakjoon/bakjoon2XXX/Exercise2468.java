package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise2468 {

    private static boolean[][] sink;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxRain;
        int n = Integer.parseInt(br.readLine());
        int[][] height = new int[n][n];
        for (int i = 0; i < n; i++) {
            height[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        maxRain = Arrays.stream(height).flatMapToInt(Arrays::stream).max().getAsInt();
        int answer = 0;
        for (int i = 0; i < maxRain; i++) {
            sink = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (height[j][k] <= i) {
                        sink[j][k] = true;
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!sink[j][k]) {
                        count++;
                        bfs(j, k);
                    }
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j) {
        Queue<Integer[]> queue = new LinkedList<>();
        sink[i][j] = true;
        queue.add(new Integer[] {i, j});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if (nr < 0 || nr >= sink.length || nc < 0 || nc >= sink[0].length) {
                    continue;
                }
                if (!sink[nr][nc]) {
                    sink[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
