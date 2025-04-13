package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5427 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static Queue<Integer[]> queue1, queue2;
    private static int w, h;
    private static char[][] map;
    private static int[][] burningTime, escapeTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            burningTime = new int[h][w];
            escapeTime = new int[h][w];

            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                Arrays.fill(burningTime[i], -1);
                Arrays.fill(escapeTime[i], -1);

                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        burningTime[i][j] = 1;
                        queue1.offer(new Integer[]{i, j});
                    } else if (map[i][j] == '@') {
                        escapeTime[i][j] = 1;
                        queue2.offer(new Integer[]{i, j});
                    }
                }
            }
            burning();
            escape();
        }
    }

    private static void burning() {
        while (!queue1.isEmpty()) {
            Integer[] now = queue1.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w) {
                    continue;
                }
                if (burningTime[next[0]][next[1]] == -1 && map[next[0]][next[1]] != '#') {
                    burningTime[next[0]][next[1]] = burningTime[now[0]][now[1]]+1;
                    queue1.offer(next);
                }
            }
        }
    }

    private static void escape() {
        while (!queue2.isEmpty()) {
            Integer[] now = queue2.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};
                int time = escapeTime[now[0]][now[1]];

                if (next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w) {
                    System.out.println(time);
                    return;
                }
                if (burningTime[next[0]][next[1]] != -1 && burningTime[next[0]][next[1]] <= time+1) {
                    continue;
                }
                if (escapeTime[next[0]][next[1]] == -1 && map[next[0]][next[1]] != '#') {
                    escapeTime[next[0]][next[1]] = time+1;
                    queue2.offer(next);
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
