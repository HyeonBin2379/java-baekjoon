package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise16174 {

    private static int[][] map;
    private static final int[][] move = {{1, 0}, {0, 1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[n][n];
        bfs(n);
    }

    private static void bfs(int size) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Integer[] {0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            if (now[0] == size-1 && now[1] == size-1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nr = now[0] + map[now[0]][now[1]] * move[i][0];
                int nc = now[1] + map[now[0]][now[1]] * move[i][1];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
                    continue;
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        System.out.println("Hing");
    }
}
