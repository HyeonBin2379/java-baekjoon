package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14442 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][m][k+1];
        bfs(n, m, k);
    }

    private static void bfs(int n, int m, int k) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0][k] = true;
        queue.offer(new Integer[]{0, 0, k, 1});

        int answer = -1;
        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int countLeft = curr[2];
            int dist = curr[3];

            if (curr[0] == n-1 && curr[1] == m-1) {
                answer = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr[0]+moves[i][0];
                int nc = curr[1]+moves[i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (map[nr][nc] == 0 && !visited[nr][nc][countLeft]) {
                    visited[nr][nc][countLeft] = true;
                    queue.offer(new Integer[]{nr, nc, countLeft, dist+1});
                } else if (map[nr][nc] == 1 && countLeft > 0 && !visited[nr][nc][countLeft-1]) {
                    visited[nr][nc][countLeft-1] = true;
                    queue.offer(new Integer[]{nr, nc, countLeft-1, dist+1});
                }
            }
        }
        System.out.println(answer);
    }
}