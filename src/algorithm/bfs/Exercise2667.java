package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Exercise2667 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int size = bfs(i, j);
                    result.add(size);
                }
            }
        }
        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }

    private static int bfs(int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(new Integer[]{row, col});

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                Integer[] next = {now[0]+move[0], now[1]+move[1]};

                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && map[next[0]][next[1]] == 1) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}
