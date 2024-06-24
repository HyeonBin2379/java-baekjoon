package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise6186 {

    private static final char[][] pasture = new char[100][100];
    private static final boolean[][] check = new boolean[100][100];
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            pasture[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && pasture[i][j] == '#') {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int i, int j) {
        Queue<Integer[]> queue = new LinkedList<>();
        check[i][j] = true;
        queue.add(new Integer[]{i, j});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if (nr < 0 || nr >= pasture.length || nc < 0 || nc >= pasture[0].length) {
                    continue;
                }
                if (!check[nr][nc] && pasture[nr][nc] == '#') {
                    check[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
