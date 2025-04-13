package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise7576 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Queue<Integer[]> queue = new ArrayDeque<>();

    private static int n, m, notRipened;
    private static int[][] box, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[m][n];
        dist = new int[m][n];

        notRipened = 0;
        for (int i = 0; i < m; i++) {
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.offer(new Integer[]{i, j});
                } else if (box[i][j] == 0) {
                    notRipened++;
                }
            }
        }

        if (notRipened == 0) {
            System.out.println(0);
            return;
        }
        bfs();
    }

    private static void bfs() {
        int lastDist = 0;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            lastDist = dist[now[0]][now[1]];

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (dist[next[0]][next[1]] == -1 && box[next[0]][next[1]] == 0) {
                    dist[next[0]][next[1]] = dist[now[0]][now[1]]+1;
                    queue.offer(next);
                    notRipened--;
                }
            }
        }

        if (notRipened > 0) {
            System.out.println(-1);
        } else {
            System.out.println(lastDist);
        }
    }
}
