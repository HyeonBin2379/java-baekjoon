package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise21736 {
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[] me;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new char[size[0]][];
        for (int i = 0; i < size[0]; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < size[1]; j++) {
                if (map[i][j] == 'I') {
                    me = new int[] {i, j};
                    break;
                }
            }
        }
        br.close();

        visited = new boolean[size[0]][size[1]];
        int result = bfs(me);
        System.out.println(result == 0 ? "TT" : result);
    }

    public static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] nextMove : move) {
                int n_row = now[0] + nextMove[0];
                int n_col = now[1] + nextMove[1];

                if (isOutOfRange(n_row, n_col) || map[n_row][n_col] == 'X') {
                    continue;
                }

                if (!visited[n_row][n_col]) {
                    count += (map[n_row][n_col] == 'P') ? 1 : 0;
                    visited[n_row][n_col] = true;
                    queue.offer(new int[] {n_row, n_col});
                }
            }
        }
        return count;
    }

    public static boolean isOutOfRange(int n_row, int n_col) {
        return n_row < 0 || n_row > map.length-1 || n_col < 0 || n_col > map[0].length-1;
    }
}
