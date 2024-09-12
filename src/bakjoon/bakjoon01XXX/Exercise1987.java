package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1987 {

    private static int n, m, answer;
    private static char[][] board;
    private static boolean[] visited;
    private static final int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        visited = new boolean[26];
        visited[board[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int count) {
        answer = Math.max(count, answer);

        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[board[nr][nc]-'A']) {
                visited[board[nr][nc] - 'A'] = true;
                dfs(nr, nc, count + 1);
                visited[board[nr][nc] - 'A'] = false;
            }
        }
    }
}
