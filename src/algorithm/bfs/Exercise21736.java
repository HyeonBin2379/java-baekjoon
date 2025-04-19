package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise21736 {

    private static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final Queue<Integer[]> queue = new ArrayDeque<>();

    private static int n, m;
    private static int[][] dist;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer[]> people = new ArrayList<>();
        map = new char[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    queue.offer(new Integer[]{i, j});
                    dist[i][j] = 0;
                } else if (map[i][j] == 'P') {
                    people.add(new Integer[]{i, j});
                }
            }
        }

        bfs();

        int count = (int)people.stream().filter(pos -> dist[pos[0]][pos[1]] != -1).count();
        System.out.println(count == 0 ? "TT" : count);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if (dist[next[0]][next[1]] == -1 && map[next[0]][next[1]] != 'X') {
                    dist[next[0]][next[1]] = dist[now[0]][now[1]]+1;
                    queue.add(next);
                }
            }
        }
    }
}
