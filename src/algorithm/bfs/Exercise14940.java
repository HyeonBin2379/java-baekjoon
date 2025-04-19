package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise14940 {

    private static final int[][] moves = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private static final Queue<Integer[]> queue = new ArrayDeque<>();

    private static int r, c;
    private static int[][] map, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        dist = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.offer(new Integer[]{i, j});
                    dist[i][j] = 0;
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        bfs();

        for (int i = 0; i < r; i++) {
            System.out.println(Arrays.stream(dist[i]).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c) {
                    continue;
                }
                if (dist[next[0]][next[1]] == -1 && map[next[0]][next[1]] == 1) {
                    dist[next[0]][next[1]] = dist[now[0]][now[1]]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
