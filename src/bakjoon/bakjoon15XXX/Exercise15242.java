package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Exercise15242 {
    private static final int[][] visited = new int[8][8];
    private static final int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] start = Arrays.stream(br.readLine().split(""))
                .map(s -> Character.isDigit(s.charAt(0)) ? s.charAt(0)-1-'0' : s.charAt(0)-'a')
                .toArray(Integer[]::new);
        Integer[] dest = Arrays.stream(br.readLine().split(""))
                .map(s -> Character.isDigit(s.charAt(0)) ? s.charAt(0)-1-'0' : s.charAt(0)-'a')
                .toArray(Integer[]::new);
        IntStream.rangeClosed(0, 7).forEach(i -> Arrays.fill(visited[i], -1));
        bfs(start, dest);
    }

    private static void bfs(Integer[] start, Integer[] end) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[start[1]][start[0]] = 0;
        queue.add(new Integer[] {start[1], start[0]});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            if (r == end[1] && c == end[0]) {
                System.out.println(visited[r][c]);
                return;
            }

            for (int[] ints : move) {
                int nr = r + ints[0];
                int nc = c + ints[1];

                if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8) {
                    continue;
                }
                if (visited[nr][nc] == -1) {
                    visited[nr][nc] = visited[r][c] + 1;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
        System.out.println(-1);
    }
}
