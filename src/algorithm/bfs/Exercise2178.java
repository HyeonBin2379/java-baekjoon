package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2178 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n, m;
    private static int[][] board, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        dist = new int[n][m];
        bfs();
        System.out.println(dist[n-1][m-1]);
    }

    private static void bfs() {
        Queue<Integer[]> queue = new ArrayDeque<>();
        dist[0][0] = 1;
        queue.offer(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if (dist[next[0]][next[1]] == 0 && board[next[0]][next[1]] == 1) {
                    dist[next[0]][next[1]] = dist[now[0]][now[1]]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
