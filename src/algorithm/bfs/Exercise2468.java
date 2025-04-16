package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2468 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n, answer;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxLen = Math.max(map[i][j], maxLen);
            }
        }

        for (int i = 0; i <= maxLen; i++) {
            int count = 0;

            visited = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!visited[r][c] && map[r][c] > i) {
                        bfs(r, c, i);
                        count++;
                    }
                }
                answer = Math.max(count, answer);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int row, int col, int sink) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(new Integer[]{row, col});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && map[next[0]][next[1]] > sink) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
