package programmers;

import java.util.LinkedList;
import java.util.Queue;

class EscapingMazeSolution {

    private Integer[] start, lever, end;
    private final int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int solution(String[] maps) {
        setMaze(maps);
        int distance1 = bfs(maps, start, lever);
        int distance2 = bfs(maps, lever, end);
        return (distance1 != 0 && distance2 != 0) ? distance1+distance2 : -1;
    }

    public void setMaze(String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            char[] mapRow = maps[i].toCharArray();
            for (int j = 0; j < maps[0].length(); j++) {
                switch (mapRow[j]) {
                    case 'S' -> start = new Integer[] {i, j};
                    case 'E' -> end = new Integer[] {i, j};
                    case 'L' -> lever = new Integer[] {i, j};
                }
            }
        }
    }
    public int bfs(String[] maps, Integer[] start, Integer[] end) {
        int[][] maze = new int[maps.length][maps[0].length()];

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {start[0], start[1]});
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int[] direction : moves) {
                int n_row = now[0] + direction[0];
                int n_col = now[1] + direction[1];

                if (n_row >= 0 && n_row < maze.length && n_col >= 0 && n_col < maze[0].length) {
                    if (maze[n_row][n_col] == 0 && maps[n_row].charAt(n_col) != 'X') {
                        maze[n_row][n_col] = maze[now[0]][now[1]] + 1;
                        queue.offer(new Integer[] {n_row, n_col});
                    }
                }
            }
        }
        return maze[end[0]][end[1]];
    }
}

public class EscapingMaze {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(new EscapingMazeSolution().solution(maps));
    }
}
