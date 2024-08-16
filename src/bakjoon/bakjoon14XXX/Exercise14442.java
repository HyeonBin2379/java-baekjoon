package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14442 {

    private static int n, m, k;
    private static char[][] map;
    private static int[][][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new int[n][m][k+1];
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[0][0][k] = 1;
        queue.offer(new Integer[]{0, 0, k});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int cnt = now[2];

            if (now[0] == n-1 && now[1] == m-1) {
                System.out.println(visited[now[0]][now[1]][now[2]]);
                return;
            }

            for (int[] ints : move) {
                int nr = r + ints[0];
                int nc = c + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                // 벽을 뚫고 지나가는 경우
                if (map[nr][nc] == '1' && cnt > 0 && visited[nr][nc][cnt-1] == 0) {
                    visited[nr][nc][cnt-1] = visited[r][c][cnt]+1;
                    queue.offer(new Integer[]{nr, nc, cnt-1});
                }
                // 정해진 길로만 이동하는 경우
                else if (map[nr][nc] == '0' && visited[nr][nc][cnt] == 0) {
                    visited[nr][nc][cnt] = visited[r][c][cnt]+1;
                    queue.offer(new Integer[]{nr, nc, cnt});
                }
            }
        }
        System.out.println(-1);
    }
}
