package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise28471 {

    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 1}};

    private static int n, answer;
    private static char[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visited = new boolean[n][n];

        Integer[] target = new Integer[2];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'F') {
                    target[0] = i;
                    target[1] = j;
                    break;
                }
            }
        }
        visited = new boolean[n][n];
        bfs(target);
    }

    private static void bfs(Integer[] start) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nx = now[0] + ints[0];
                int ny = now[1] + ints[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (!visited[nx][ny] && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    answer++;
                    queue.add(new Integer[]{nx, ny});
                }
            }
        }
        System.out.println(answer);
    }
}
