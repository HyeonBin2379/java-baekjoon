package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Exercise7562 {

    private static final int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}, {2, -1}, {2, 1}};

    private static int n;
    private static int[][] dist;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            dist = new int[n][n];
            visited = new boolean[n][n];

            Integer[] start = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer[] end = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            bfs(start, end);
        }
    }

    private static void bfs(Integer[] start, Integer[] end) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0].equals(end[0]) && now[1].equals(end[1])) {
                System.out.println(dist[now[0]][now[1]]);
                return;
            }

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    dist[next[0]][next[1]] = dist[now[0]][now[1]]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
