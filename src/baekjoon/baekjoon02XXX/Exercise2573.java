package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise2573 {

    private static int n, m;
    private static int[][] map, melt;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int year = 0;
        while (true) {
            melt = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        globalWarming(i, j);
                    }
                }
            }

            List<Integer[]> iceberg = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = Math.max(0, map[i][j]-melt[i][j]);
                    if (map[i][j] != 0) {
                        iceberg.add(new Integer[] {i, j});
                    }
                }
            }


            int count = 0;
            visited = new boolean[n][m];
            for (Integer[] now : iceberg) {
                if (!visited[now[0]][now[1]]) {
                    iceberg(now[0], now[1]);
                    count++;
                }
            }
            year++;

            if (count != 1) {
                System.out.println(count > 1 ? year : 0);
                return;
            }
        }
    }

    private static void globalWarming(int r, int c) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (map[nr][nc] == 0) {
                melt[r][c]++;
            }
        }
    }
    private static void iceberg(int r, int c) {
        visited[r][c] = true;
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (!visited[nr][nc] && map[nr][nc] != 0) {
                iceberg(nr, nc);
            }
        }
    }
}
