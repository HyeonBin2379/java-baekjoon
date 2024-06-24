package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2206 {
    private static int row, col;
    private static char[][] maze;
    private static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maze = new char[row][col];
        distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            maze[i] = br.readLine().toCharArray();
        }
        br.close();

        if (row == 1 && col == 1) {
            System.out.println(1);
            return;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[2][row][col];
        int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        queue.offer(new Integer[] {0, 0, 0});
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int[] nextMove : move) {
                int x = now[0]+nextMove[0];
                int y = now[1]+nextMove[1];

                if (x >= 0 && y >= 0 && x < row && y < col) {
                    if (maze[x][y] == '1') {
                        if (now[2] == 0 && !visited[1][x][y]) {
                            visited[now[2]][x][y] = true;
                            distance[x][y] = distance[now[0]][now[1]]+1;
                            queue.offer(new Integer[]{x, y, 1});
                        }
                    } else {
                        if (!visited[now[2]][x][y]) {
                            visited[now[2]][x][y] = true;
                            distance[x][y] = distance[now[0]][now[1]]+1;
                            queue.offer(new Integer[]{x, y, now[2]});
                        }
                    }

                    if (x == row-1 && y == col-1) {
                        System.out.println(distance[x][y]+1);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
