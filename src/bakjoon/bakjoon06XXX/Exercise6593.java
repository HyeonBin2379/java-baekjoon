package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise6593 {

    private static int l, r, c;
    private static char[][][] building;
    private static int[][][] visited;
    private static final int[][] MOVE = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    private static Queue<Integer[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            queue = new LinkedList<>();
            building = new char[l][r][c];
            visited = new int[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    building[i][j] = br.readLine().toCharArray();
                    Arrays.fill(visited[i][j], -1);
                    for (int k = 0; k < c; k++) {
                        if (building[i][j][k] == 'S') {
                            visited[i][j][k] = 0;
                            queue.offer(new Integer[]{i, j, k});
                        }
                    }
                }
                br.readLine();
            }
            bfs();
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            if (building[now[0]][now[1]][now[2]] == 'E') {
                System.out.printf("Escaped in %d minute(s).\n", visited[now[0]][now[1]][now[2]]);
                return;
            }

            for (int[] ints : MOVE) {
                int nl = now[0] + ints[0];
                int nr = now[1] + ints[1];
                int nc = now[2] + ints[2];

                if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (visited[nl][nr][nc] == -1 && building[nl][nr][nc] != '#') {
                    visited[nl][nr][nc] = visited[now[0]][now[1]][now[2]] + 1;
                    queue.offer(new Integer[]{nl, nr, nc});
                }
            }
        }
        System.out.println("Trapped!");
    }
}
