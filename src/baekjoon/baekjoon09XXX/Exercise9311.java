package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9311 {

    private static char[][] maze;
    private static int[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            Queue<Integer[]> queue = new LinkedList<>();
            maze = new char[r][c];
            visited = new int[r][c];
            IntStream.rangeClosed(0, r-1).forEach(index -> Arrays.fill(visited[index], -1));
            for (int i = 0; i < r; i++) {
                maze[i] = br.readLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (maze[i][j] == 'S') {
                        visited[i][j] = 0;
                        queue.add(new Integer[] {i, j});
                    }
                }
            }
            bfs(queue);
        }
    }

    private static void bfs(Queue<Integer[]> queue) {

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (maze[now[0]][now[1]] == 'G') {
                System.out.printf("Shortest Path: %d\n", visited[now[0]][now[1]]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (visited[nr][nc] == -1 && maze[nr][nc] != 'X') {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        System.out.println("No Exit");
    }
}
