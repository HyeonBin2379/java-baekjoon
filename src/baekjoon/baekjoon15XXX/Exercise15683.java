package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise15683 {

    private static final int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int[][][] directionByCctv = {
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    private static final List<Integer[]> camera = new ArrayList<>();

    private static int n, m, min;
    private static int[][] map;
    private static boolean[][] scanned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int notSpace = 0;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0) {
                    if (map[i][j] >= 1 && map[i][j] <= 5) {
                        camera.add(new Integer[]{i, j, map[i][j]-1});
                    }
                    notSpace++;
                }
            }
        }

        min = Integer.MAX_VALUE;
        scanned = new boolean[n][m];
        dfs(0, 0);
        System.out.println(min-notSpace);
    }

    private static void dfs(int level, int total) {
        if (level == camera.size()) {
            min = Math.min(min, n*m-total);
            return;
        }

        Integer[] cctvInfo = camera.get(level);
        int type = cctvInfo[2];
        int startRow = cctvInfo[0];
        int startCol = cctvInfo[1];

        boolean[][] temp = copy();
        for (int row = 0; row < directionByCctv[type].length; row++) {
            int cnt = Arrays.stream(directionByCctv[type][row])
                    .map(cctvDir -> watch(startRow, startCol, direction[cctvDir][0], direction[cctvDir][1]))
                    .sum();

            dfs(level+1, total+cnt);
            rollback(temp);
        }
    }

    private static boolean[][] copy() {
        boolean[][] temp = new boolean[n][m];
        IntStream.range(0, n).forEach(idx -> temp[idx] = scanned[idx].clone());
        return temp;
    }

    private static void rollback(boolean[][] temp) {
        IntStream.range(0, n).forEach(idx -> scanned[idx] = temp[idx].clone());
    }

    private static int watch(int row, int col, int moveRow, int moveCol) {
        int count = 0;

        while (isInRange(row, col) && map[row][col] != 6) {
            if (!scanned[row][col]) {
                scanned[row][col] = true;
                if (map[row][col] == 0) {
                    count++;
                }
            }
            row += moveRow;
            col += moveCol;
        }
        return count;
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}