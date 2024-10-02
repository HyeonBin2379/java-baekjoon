package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16390 {

    private static int m, n;
    private static char[][] petriDish;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        petriDish = new char[m][n];
        for (int i = 0; i < m; i++) {
            petriDish[i] = br.readLine().toCharArray();
        }

        int loopCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (petriDish[i][j] == '#') {
                    loopCount++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(loopCount);
    }

    private static void dfs(int r, int c) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if (petriDish[nr][nc] == '#') {
                petriDish[nr][nc] = '.';
                dfs(nr, nc);
            }
        }
    }
}
