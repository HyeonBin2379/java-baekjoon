package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise4179 {

    private static int r, c;

    private static char[][] map;
    private static int[][] escaping, burning;
    private static final int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Queue<Pair> queueFire = new LinkedList<>();
        Queue<Pair> queueEscape = new LinkedList<>();
        map = new char[r][c];
        escaping = new int[r][c];
        burning = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(escaping[i], -1);
            Arrays.fill(burning[i], -1);
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'F') {
                    queueFire.offer(new Pair(i, j));
                    burning[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    if (i == 0 || i == r-1 || j == 0 || j == c-1) {
                        System.out.println(1);
                        return;
                    }
                    queueEscape.offer(new Pair(i, j));
                    escaping[i][j] = 0;
                }
            }
        }

        fire(queueFire);
        System.out.println(escape(queueEscape));
    }

    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void fire(Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + move[i][0];
                int nc = now.c + move[i][1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c
                        || map[nr][nc] == '#' || burning[nr][nc] != -1) {
                    continue;
                }
                burning[nr][nc] = burning[now.r][now.c] + 1;
                queue.add(new Pair(nr, nc));
            }
        }
    }

    private static String escape(Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            int time = escaping[now.r][now.c] + 1;

            if (now.r == 0 || now.r == r-1 || now.c == 0 || now.c == c-1) {
                return Integer.toString(time);
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + move[i][0];
                int nc = now.c + move[i][1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc] == '#') {
                    continue;
                }
                if ((burning[nr][nc] != -1 && burning[nr][nc] <= time) || escaping[nr][nc] != -1) {
                    continue;
                }
                escaping[nr][nc] = escaping[now.r][now.c] + 1;
                queue.add(new Pair(nr, nc));
            }
        }
        return "IMPOSSIBLE";
    }
}
