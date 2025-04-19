package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise6593 {

    private static final Queue<Integer[]> queue = new ArrayDeque<>();
    private static final int[][] moves = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    private static int l, r, c;
    private static int[][][] dist;
    private static char[][][] map;


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

            map = new char[l][r][c];
            dist = new int[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    Arrays.fill(dist[i][j], -1);

                    for (int k = 0; k < c; k++) {
                        if (map[i][j][k] == 'S') {
                            queue.offer(new Integer[]{i, j, k});
                            dist[i][j][k] = 0;
                        }
                    }
                }
                br.readLine();
            }

            bfs();
            queue.clear();
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (map[now[0]][now[1]][now[2]] == 'E') {
                System.out.printf("Escaped in %d minute(s).\n", dist[now[0]][now[1]][now[2]]);
                return;
            }

            for (int[] move : moves) {
                int nl = now[0] + move[0];
                int nr = now[1] + move[1];
                int nc = now[2] + move[2];

                if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (dist[nl][nr][nc] == -1 && map[nl][nr][nc] != '#') {
                    dist[nl][nr][nc] = dist[now[0]][now[1]][now[2]]+1;
                    queue.offer(new Integer[]{nl, nr, nc});
                }
            }
        }
        System.out.println("Trapped!");
    }
}
