package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Exercise14940 {
    private static int row, col;
    private static int[][] maze;
    private static int[][] distance = new int[row][col];
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maze = new int[row][col];
        distance = new int[row][col];
        visited = new boolean[row][col];
        int start_row = 0, start_col = 0;
        for (int i = 0; i < row; i++) {
            maze[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                if (maze[i][j] == 2) {
                    start_row = i;
                    start_col = j;
                }
            }
        }
        br.close();

        bfs(start_row, start_col);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && maze[i][j] == 1) {
                    distance[i][j] = -1;
                }
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int row_start, int col_start) {
        int[][] move = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[]{row_start, col_start});
        visited[row_start][col_start] = true;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int[] direction : move) {
                int x = now[0]+direction[0];
                int y = now[1]+direction[1];

                if (x >= 0 && x < row && y >= 0 && y < col) {
                    if (maze[x][y] != -1 && !visited[x][y]) {
                        visited[x][y] = true;
                        distance[x][y] = distance[now[0]][now[1]]+1;
                        queue.offer(new Integer[]{x,y});
                    }
                }
            }
        }
    }
}
