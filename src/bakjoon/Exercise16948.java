package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise16948 {
    private static final int[][] move = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        visited = new int[size][size];
        int[] startToEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        bfs(startToEnd, size);
        System.out.println(visited[startToEnd[2]][startToEnd[3]] == 0 ? -1 : visited[startToEnd[2]][startToEnd[3]]);
    }

    public static void bfs(int[] startToEnd, int size) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startToEnd[0], startToEnd[1]});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] next : move) {
                int n_row = now[0]+next[0];
                int n_col = now[1]+next[1];

                if (n_row < 0 || n_row >= size || n_col < 0 || n_col >= size) {
                    continue;
                }

                if (visited[n_row][n_col] == 0) {
                    visited[n_row][n_col] = visited[now[0]][now[1]] + 1;
                    queue.offer(new int[] {n_row, n_col});
                }
            }
        }
    }
}
