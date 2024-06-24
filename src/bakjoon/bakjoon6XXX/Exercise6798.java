package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Exercise6798 {

    private static final int[][] visited = new int[9][9];
    private static final int[][] move = {{-2,-1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        IntStream.rangeClosed(0, 8).forEach(index -> Arrays.fill(visited[index], -1));
        bfs(start, end);
    }

    private static void bfs(int[] start, int[] end) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = 0;
        queue.add(new Integer[] {start[0], start[1]});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0] == end[0] && now[1] == end[1]) {
                System.out.println(visited[now[0]][now[1]]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 1 || nr > 8 || nc < 1 || nc > 8 || visited[nr][nc] != -1) {
                    continue;
                }
                visited[nr][nc] = visited[now[0]][now[1]] + 1;
                queue.add(new Integer[] {nr, nc});
            }
        }
    }
}
