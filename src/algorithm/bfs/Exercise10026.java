package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise10026 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n, count1, count2;
    private static char[][] map;
    private static boolean[][] visited1, visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    bfsNotColorBlinded(i, j, map[i][j]);
                }
                if (!visited2[i][j]) {
                    bfsColorBlinded(i, j, map[i][j]);
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    private static void bfsNotColorBlinded(int row, int col, char color) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited1[row][col] = true;
        queue.offer(new Integer[]{row, col});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited1[next[0]][next[1]] && map[next[0]][next[1]] == color) {
                    visited1[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
        count1++;
    }

    private static void bfsColorBlinded(int row, int col, char color) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited1[row][col] = true;
        queue.offer(new Integer[]{row, col});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited2[next[0]][next[1]]
                        && (isColorBlinded(next[0], next[1], color) || (color == 'B' && map[next[0]][next[1]] == color))) {
                    visited2[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
        count2++;
    }

    private static boolean isColorBlinded(int row, int col, char color) {
        return (color == 'R' || color == 'G')
                && (map[row][col] == 'R' || map[row][col] == 'G');
    }
}
