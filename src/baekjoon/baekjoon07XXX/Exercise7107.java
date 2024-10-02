package baekjoon.baekjoon07XXX;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise7107 {

    private static int n, m;
    private static int[][] visited;
    private static final int[][] move = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int i = sc.nextInt()-1;
        int j = sc.nextInt()-1;
        visited = new int[m][n];
        IntStream.range(0, m).forEach(idx -> Arrays.fill(visited[idx], -1));
        bfs(j, i);
    }

    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[0][0] = 0;
        queue.offer(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0] == r && now[1] == c) {
                System.out.println(visited[now[0]][now[1]]);
                return;
            }
            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (visited[nr][nc] == -1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println("NEVAR");
    }
}