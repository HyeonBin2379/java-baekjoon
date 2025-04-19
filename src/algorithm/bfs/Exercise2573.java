package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise2573 {

    private static final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int n, m;
    private static int[][] map, melt;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        melt = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer[]> ices = new ArrayList<>();
        int answer = 0;
        while (hasIce()) {
            ices.clear();
            initialized();

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        ices.add(new Integer[]{i, j});
                        if (!visited[i][j]) {
                            bfs(i, j);
                            count++;
                        }
                    }
                }
            }

            if (count > 1) {
                System.out.println(answer);
                return;
            }


            melt = new int[n][m];
            for (Integer[] pos : ices) {
                if (map[pos[0]][pos[1]] > 0) {
                    sink(pos[0], pos[1]);
                }
            }
            for (Integer[] pos : ices) {
                map[pos[0]][pos[1]] = Math.max(map[pos[0]][pos[1]]-melt[pos[0]][pos[1]], 0);
            }

            answer++;
        }
        System.out.println(0);
    }

    private static boolean hasIce() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void initialized() {
        IntStream.range(0, n).forEach(idx -> {
            Arrays.fill(visited[idx], false);
            Arrays.fill(melt[idx], 0);
        });
    }

    private static void sink(int r, int c) {
        for (int[] move : moves) {
            Integer[] next = {r+move[0], c+move[1]};

            if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                continue;
            }
            if (map[next[0]][next[1]] == 0) {
                melt[r][c]++;
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && map[next[0]][next[1]] > 0) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
