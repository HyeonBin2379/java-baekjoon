package baekjoon.baekjoon17XXX;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise17198 {

    private static class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final char[][] map = new char[10][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point barn = null, lake = null;

        for (int i = 0; i < 10; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'B') {
                    barn = new Point(i, j, 0);
                }
                if (map[i][j] == 'L') {
                    lake = new Point(i, j, 0);
                }
            }
        }
        System.out.println(bfs(barn, lake));
    }

    static int bfs(Point barn, Point lake) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][10];

        queue.add(lake);
        visited[lake.x][lake.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !visited[nx][ny] && map[nx][ny] != 'R') {
                    if (Math.abs(nx - barn.x) + Math.abs(ny - barn.y) == 1) {
                        return current.dist + 1;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.dist + 1));
                }
            }
        }
        return -1;
    }
}
