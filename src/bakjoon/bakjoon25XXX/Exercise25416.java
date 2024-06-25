package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise25416 {

    private static final int[][] board = new int[5][5];
    private static final int[][] visited = new int[5][5];
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(visited[i], -1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        bfs(r, c);
    }

    private static void bfs(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = 0;
        queue.add(new Integer[] {r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (board[now[0]][now[1]] == 1) {
                System.out.println(visited[now[0]][now[1]]);
                return;
            }

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr > 4 || nc < 0 || nc > 4) {
                    continue;
                }
                if (visited[nr][nc] == -1 && board[nr][nc] != -1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
        System.out.println(-1);
    }
}
