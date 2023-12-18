package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Exercise2178 {
    private static int row, col;
    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maze = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            maze[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        bfs(0, 0);

        System.out.println(maze[row-1][col-1]);
    }

    public static void bfs(int row_now, int col_now) {
        int[][] move = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[]{row_now, col_now});
        visited[row_now][col_now] = true;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int[] direction : move) {
                int x = now[0]+direction[0];
                int y = now[1]+direction[1];

                if (x >= 0 && y >= 0 && x < row && y < col) {
                    if (maze[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]]+1;
                        queue.offer(new Integer[]{x, y});
                    }
                }
            }
        }
    }
}
