package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1012 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int m, n;
    private static int[][] farm;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(st.nextToken());
            Queue<Integer[]> queue = new ArrayDeque<>();

            farm = new int[n][m];
            visited = new boolean[n][m];
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                farm[r][c] = 1;
                queue.add(new Integer[]{r, c});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Integer[] now = queue.poll();

                if (!visited[now[0]][now[1]] && farm[now[0]][now[1]] == 1) {
                    bfs(now);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(Integer[] start) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && farm[next[0]][next[1]] == 1) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
