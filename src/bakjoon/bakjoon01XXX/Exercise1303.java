package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Exercise1303 {

    private static int n, m;
    private static char[][] field;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        field = new char[m][n];
        for (int i = 0; i < m; i++) {
            field[i] = br.readLine().toCharArray();
        }

        int troop = 0, enemy = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    switch (field[i][j]) {
                        case 'W' -> troop += count(i, j, color -> color == 'W');
                        case 'B' -> enemy += count(i, j, color -> color == 'B');
                    }
                }
            }
        }
        System.out.println(troop + " " + enemy);
    }

    private static int count(int r, int c, Predicate<Character> isColor) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new Integer[] {r, c});

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] next : move) {
                int nr = now[0] + next[0];
                int nc = now[1] + next[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }
                if (isColor.test(field[nr][nc])) {
                    visited[nr][nc] = true;
                    count++;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        return count*count;
    }
}
