package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1388 {
    private static char[][] floor;
    private static boolean[][] visited;
    private static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        visited = new boolean[row][col];
        floor = new char[row][col];
        for (int i = 0; i < row; i++) {
            floor[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) {
                    continue;
                }

                dfs(i, j, floor[i][j] == '-');
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i, int j, boolean tileType) {
        visited[i][j] = true;
        if (tileType) {
            if (j+1 < col && floor[i][j+1] == '-') {
                dfs(i, j+1, true);
            }
        } else {
            if (i+1 < row && floor[i+1][j] != '-') {
                dfs(i+1, j, false);
            }
        }
    }
}
