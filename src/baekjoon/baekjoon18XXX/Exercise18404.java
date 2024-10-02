package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise18404 {
    private static final int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeAndEnemyCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] enemy = new int[sizeAndEnemyCount[1]][];

        visited = new int[sizeAndEnemyCount[0]+1][sizeAndEnemyCount[0]+1];
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        bfs(start, sizeAndEnemyCount[0]);
        Arrays.stream(enemy).forEach(ints -> System.out.print(visited[ints[1]][ints[0]]-1 + " "));
    }

    public static void bfs(int[] start, int size) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[1]][start[0]] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] next : move) {
                int nx = now[0] + next[0];
                int ny = now[1] + next[1];

                if (nx < 1 || nx > size || ny < 1 || ny > size) {
                    continue;
                }

                if (visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[now[1]][now[0]] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
