package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exercise2146 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final List<Integer[]> position = new ArrayList<>();

    private static int n, minDist;
    private static int[][] map, dist;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 지도 입력
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 각각의 섬을 구분하고, 해안가를 모두 찾아 리스트에 저장
        visited = new boolean[n][n];
        dist = new int[n][n];
        int label = 1;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    labeling(i, j, ++label);
                }
            }
        }

        // 구한 각각의 해안가에 대해, 가능한 최단거리를 구한다.
        minDist = Integer.MAX_VALUE;
        for (Integer[] start : position) {
            visited = new boolean[n][n];
            bfs(start, map[start[0]][start[1]]);
        }

        System.out.println(minDist);
    }

    private static void labeling(int r, int c, int label) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        map[r][c] = label;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            // 섬의 한 지점이 해안가인지 확인
            if (isBeach(cur[0], cur[1])) {
                position.add(cur);
            }

            for (int[] next : moves) {
                int nr = cur[0] + next[0];
                int nc = cur[1] + next[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = label;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }

    private static boolean isBeach(int r, int c) {
        for (int[] next : moves) {
            int nr = r + next[0];
            int nc = c + next[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            if (map[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void bfs(Integer[] start, int label) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;
        queue.offer(new Integer[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            // 처음 섬과는 다른 섬에 도착하면 최소거리로 갱신 후 그대로 종료
            if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != label) {
                minDist = Math.min(dist[cur[0]][cur[1]]-1, minDist);
                return;
            }

            for (int[] next : moves) {
                int nr = cur[0]+next[0];
                int nc = cur[1]+next[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                // 다음 지점이 바다나 다른 섬일 때만 큐에 추가
                if (!visited[nr][nc] && map[nr][nc] != label) {
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[cur[0]][cur[1]]+1;
                    queue.offer(new Integer[] {nr, nc});
                }
            }
        }
        // 처음 섬에서 다른 섬으로 갈 수 없으면 그대로 종료
    }
}
