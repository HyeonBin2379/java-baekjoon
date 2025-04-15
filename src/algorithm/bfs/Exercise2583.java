package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2583 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int m, n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        int k = Integer.parseInt(st.nextToken());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startC = Integer.parseInt(st.nextToken());
            int startR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());

            for (int i = startR; i < endR; i++) {
                for (int j = startC; j < endC; j++) {
                    map[i][j] = 1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int size = bfs(i, j);
                    result.add(size);
                }
            }
        }
        System.out.println(result.size());
        result.stream().sorted().forEach(size -> System.out.print(size + " "));
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

                if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n) {
                    continue;
                }
                if (!visited[next[0]][next[1]] && map[next[0]][next[1]] == 0) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}
