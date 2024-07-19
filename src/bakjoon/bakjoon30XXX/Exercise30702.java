package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise30702 {
    private static int n, m, count;
    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] flag1 = new char[n][m];
        for (int i = 0; i < n; i++) {
            flag1[i] = br.readLine().toCharArray();
        }
        char[][] flag2 = new char[n][m];
        for (int i = 0; i < n; i++) {
            flag2[i] = br.readLine().toCharArray();
        }

        int[][] visited1 = new int[n][m];
        count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] == 0) {
                    bfs(flag1, i, j, visited1);
                    count++;
                }
            }
        }

        int[][] visited2 = new int[n][m];
        count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited2[i][j] == 0) {
                    bfs(flag2, i, j, visited2, visited1);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] != visited2[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static void bfs(char[][] board, int x, int y, int[][] visited) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        visited[x][y] = count;

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            for (int[] ints : move) {
                int nx = cur[0] + ints[0];
                int ny = cur[1] + ints[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 0) {
                    continue;
                }
                if (board[nx][ny] == board[cur[0]][cur[1]]) {
                    visited[nx][ny] = count;
                    queue.add(new Integer[]{nx, ny});
                }
            }
        }
    }

    private static void bfs(char[][] board, int x, int y, int[][] visited, int[][] compareVis) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        visited[x][y] = count;

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            for (int[] ints : move) {
                int nx = cur[0] + ints[0];
                int ny = cur[1] + ints[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 0) {
                    continue;
                }
                if (board[nx][ny] == board[cur[0]][cur[1]] && compareVis[nx][ny] == compareVis[cur[0]][cur[1]]) {
                    visited[nx][ny] = count;
                    queue.add(new Integer[]{nx, ny});
                }
            }
        }
    }
}