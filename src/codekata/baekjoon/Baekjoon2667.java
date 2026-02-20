package codekata.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon2667 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final List<Integer> answers = new ArrayList<>();

    private static boolean[][] visited;
    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    int houseCnt = bfs(i, j);
                    answers.add(houseCnt);
                }
            }
        }
        System.out.println(answers.size());
        answers.stream().sorted().forEach(System.out::println);
    }

    private static int bfs(int startRow, int startCol) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.add(new Integer[] {startRow, startCol});

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                int nextRow = now[0] + move[0];
                int nextCol = now[1] + move[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    count++;
                    queue.add(new Integer[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return count;
    }
}
