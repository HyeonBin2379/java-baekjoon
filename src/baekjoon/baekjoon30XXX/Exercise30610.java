package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise30610 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> result = new ArrayList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int size = findLake(i, j);
                    result.add(size);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        System.out.println(result.stream().map(lake -> Integer.toString(lake)).collect(Collectors.joining(" ")));
    }

    private static int findLake(int r, int c) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new Integer[]{r, c});

        int count = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : MOVE) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    count++;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
        return count;
    }
}
