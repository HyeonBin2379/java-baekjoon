package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise13903 {

    private static int r, c;
    private static int[][] map, move, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(visited[i], -1);
        }

        int n = Integer.parseInt(br.readLine());
        move = new int[n][2];
        for (int i = 0; i < n; i++) {
            move[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < c; i++) {
            if (map[0][i] == 1) {
                queue.offer(new Integer[]{0, i});
                visited[0][i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            if (now[0] == r-1) {
                System.out.println(visited[now[0]][now[1]]);
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (visited[nr][nc] == -1 && map[nr][nc] == 1) {
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println(-1);
    }
}
