package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise4963 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int w, h;
    private static final int[][] dir = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int[] next : dir) {
            int nextRow = i + next[0];
            int nextCol = j + next[1];

            if (isInRange(nextRow, nextCol) && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol);
            }
        }
    }

    private static boolean isInRange(int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w;
    }
}
