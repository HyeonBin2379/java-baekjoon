package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Exercise2146 {

    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int[][] map, visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 2;
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = count;
                    visited[i][j] = 1;
                    numbering(i, j, count++);
                }
                if (map[i][j] != 0) {
                    visited = new int[n][n];
                    IntStream.rangeClosed(0, n-1).forEach(index -> Arrays.fill(visited[index], -1));
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);
    }

    private static void numbering(int r, int c, int num) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n
                    || visited[nr][nc] == 1 || map[nr][nc] != 1) {
                continue;
            }
            visited[nr][nc] = 1;
            map[nr][nc] = num;
            numbering(nr, nc, num);
        }
    }
    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = 0;
        queue.add(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int dist = visited[now[0]][now[1]];

            // 다리 길이가 최소값을 넘어가는 경우는 가지치기
            if (dist >= min) {
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] != -1) {
                    continue;
                }

                if (map[nr][nc] == 0) { // 다음 지점이 바다인 경우
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                    queue.add(new Integer[]{nr, nc});
                } else if (map[nr][nc] != map[r][c]) {  // 다음 지점이 다른 섬인 경우
                    min = Math.min(dist, min);
                }
            }
        }
    }
}
