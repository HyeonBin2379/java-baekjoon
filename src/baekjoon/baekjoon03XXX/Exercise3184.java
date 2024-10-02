package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise3184 {

    private static int r, c, sheep, wolf;
    private static char[][] pasture;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pasture = new char[r][c];
        sheep = 0;
        wolf = 0;
        for (int i = 0; i < r; i++) {
            pasture[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                switch (pasture[i][j]) {
                    case 'v' -> wolf++;
                    case 'o' -> sheep++;
                }
            }
        }

        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && pasture[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int startR, int startC) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startR][startC] = true;
        queue.add(new Integer[] {startR, startC});

        int s = 0, w = 0;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            switch (pasture[now[0]][now[1]]) {
                case 'v' -> w++;
                case 'o' -> s++;
            }

            for (int[] next : move) {
                int nr = now[0] + next[0];
                int nc = now[1] + next[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (!visited[nr][nc] && pasture[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        if (s > w) {
            wolf -= w;
        } else {
            sheep -= s;
        }
    }
}
