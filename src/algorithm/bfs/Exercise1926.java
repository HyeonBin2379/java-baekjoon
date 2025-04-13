package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1926 {

    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private static int n, m;
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][m];
        int pictureCnt = 0;
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(i, j));
                    pictureCnt++;
                }
            }
        }
        System.out.println(pictureCnt);
        System.out.println(maxSize);
    }

    private static int bfs(int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(new Integer[]{row, col});

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && board[next[0]][next[1]] == 1) {
                    visited[next[0]][next[1]] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}
