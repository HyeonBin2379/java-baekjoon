package codekata.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EscapingMaze {

    private final Integer[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private char[][] maze;

    private Integer[] start, lever, end;

    public int solution(String[] maps) {
        int answer = -1;

        setup(maps);
        int dist1 = bfs(start, lever);
        int dist2 = bfs(lever, end);

        if (dist1 != -1 && dist2 != -1) {
            answer = dist1+dist2;
        }
        return answer;
    }

    private void setup(String[] maps) {
        maze = new char[maps.length][maps[0].length()];
        lever = new Integer[2];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < maze[i].length; j++) {
                switch (maze[i][j]) {
                    case 'S':
                        start = new Integer[]{i, j};
                        break;
                    case 'L':
                        lever = new Integer[]{i, j};
                        break;
                    case 'E':
                        end = new Integer[]{i, j};
                        break;
                }
            }
        }
    }

    private int bfs(Integer[] from, Integer[] to) {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[][] visited = new Integer[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[from[0]][from[1]] = 0;
        queue.add(from);

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (Integer[] move : moves) {
                int nr = now[0] + move[0];
                int nc = now[1] + move[1];

                if (now[0].equals(to[0]) && now[1].equals(to[1])) {
                    return visited[to[0]][to[1]];
                }

                if (nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length) {
                    continue;
                }
                if (visited[nr][nc] == -1 && maze[nr][nc] != 'X') {
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int result = new EscapingMaze().solution(maps);
        System.out.println(result);
    }
}
