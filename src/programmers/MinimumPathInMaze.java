package programmers;

import java.util.LinkedList;
import java.util.Queue;

class MinimumPathInMazeSolution {
    private final int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps, 0, 0);
        return (maps[maps.length-1][maps[0].length-1] != 1) ? maps[maps.length-1][maps[0].length-1] : -1;
    }

    public void bfs(int[][] maps, int s_row, int s_col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {s_row, s_col});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] direction : moves) {
                int n_row = now[0] + direction[0];
                int n_col = now[1] + direction[1];

                if (n_row >= 0 && n_row < maps.length && n_col >= 0 && n_col < maps[0].length) {
                    if(maps[n_row][n_col] != 0 && !visited[n_row][n_col]) {
                        visited[n_row][n_col] = true;
                        maps[n_row][n_col] = maps[now[0]][now[1]] + 1;
                        queue.offer(new int[] {n_row, n_col});
                    }
                }
            }
        }
    }
}
public class MinimumPathInMaze {
    public static void main(String[] args) {
        int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(new MinimumPathInMazeSolution().solution(map));
    }
}
