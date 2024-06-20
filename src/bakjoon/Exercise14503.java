package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14503 {

    private static int[][] map;
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int count, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        count = 1;
        dfs(r, c, d);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int dir) {
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + move[dir][0];
            int ny = y + move[dir][1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                count++;
                dfs(nx, ny, dir);
                return;
            }
        }

        int back = (dir + 2) % 4;
        int bx = x + move[back][0];
        int by = y + move[back][1];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, dir);
        }
    }
}
