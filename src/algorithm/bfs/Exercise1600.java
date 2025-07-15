package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1600 {

    private static final int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static final int[][] normal = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        for (int i = 0; i < h; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs(h, w, k));
    }

    private static int bfs(int h, int w, int k) {
        Queue<Integer[]> queue = new LinkedList<>();
        int answer = -1;
        visited[0][0][0] = true;
        queue.offer(new Integer[]{0, 0, 0, 0});

        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int count = curr[2];
            int dist = curr[3];

            if (curr[0] == h-1 && curr[1] == w-1) {
                answer = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr[0]+normal[i][0];
                int nc = curr[1]+normal[i][1];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 1) {
                    continue;
                }
                if (!visited[nr][nc][count]) {
                    visited[nr][nc][count] = true;
                    queue.offer(new Integer[]{nr, nc, count, dist+1});
                }
            }
            if (count < k) {
                for (int i = 0; i < 8; i++) {
                    int nr = curr[0]+horse[i][0];
                    int nc = curr[1]+horse[i][1];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 1) {
                        continue;
                    }
                    if (!visited[nr][nc][count+1]) {
                        visited[nr][nc][count+1] = true;
                        queue.offer(new Integer[]{nr, nc, count+1, dist+1});
                    }
                }
            }
        }
        return answer;
    }
}
