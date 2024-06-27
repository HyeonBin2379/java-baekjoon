package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2636 {

    private static int n, m, cheese;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cheese += (int) Arrays.stream(map[i]).filter(value -> value == 1).count();
        }

        int time = 0;
        while (true) {
            visited = new boolean[n][m];
            int melted = bfs();
            if (cheese - melted == 0) {
                System.out.println((time+1) + "\n" + cheese);
                return;
            }
            cheese -= melted;
            time++;
        }
    }

    private static int bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Integer[] {0, 0});

        int count = 0;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                if (map[nr][nc] == 0) {
                    queue.add(new Integer[]{nr, nc});
                } else {
                    map[nr][nc] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}
