package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1189 {

    private static int r, c, k, answer;
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];
        answer = 0;
        dfs(r-1, 0, 1);
        System.out.println(answer);
    }
    private static void dfs(int curR, int curC, int step) {
        if (step == k) {
            if (curR == 0 && curC == c-1) {
                answer++;
            }
            return;
        }

        visited[curR][curC] = true;
        for (int[] ints : move) {
            int nr = curR + ints[0];
            int nc = curC + ints[1];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && map[nr][nc] != 'T') {
                dfs(nr, nc, step + 1);
            }
        }
        visited[curR][curC] = false;
    }
}
