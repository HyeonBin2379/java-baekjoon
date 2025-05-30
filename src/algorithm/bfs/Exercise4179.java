package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise4179 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Queue<Integer[]> queue1 = new ArrayDeque<>();
    private static final Queue<Integer[]> queue2 = new ArrayDeque<>();

    private static int r, c;
    private static char[][] map;
    private static int[][] burningTime, escapeTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        burningTime = new int[r][c];
        escapeTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(burningTime[i], -1);
            Arrays.fill(escapeTime[i], -1);
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'F') {
                    burningTime[i][j] = 0;
                    queue1.offer(new Integer[]{i, j});
                } else if (map[i][j] == 'J') {
                    queue2.offer(new Integer[]{i, j});
                    escapeTime[i][j] = 0;
                }
            }
        }

        burning();
        escape();
    }

    private static void burning() {
        while (!queue1.isEmpty()) {
            Integer[] now = queue1.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c) {
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
                int time = escapeTime[now[0]][now[1]]+1;

                if (next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c) {
                    System.out.println(time);
                    return;
                }
                if (burningTime[next[0]][next[1]] != -1 && burningTime[next[0]][next[1]] <= time) {
                    continue;
                }
                if (escapeTime[next[0]][next[1]] == -1 && map[next[0]][next[1]] != '#') {
                    escapeTime[next[0]][next[1]] = time;
                    queue2.offer(next);
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
