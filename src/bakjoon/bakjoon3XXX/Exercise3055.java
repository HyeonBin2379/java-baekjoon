package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise3055 {

    private static int r, c;
    private static char[][] worldMap;
    private static int[][] route, water;
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        worldMap = new char[r][c];

        Queue<Integer[]> nextRoute = new LinkedList<>();
        Queue<Integer[]> nextFlood = new LinkedList<>();
        setArray();
        for (int i = 0; i < r; i++) {
            worldMap[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                switch (worldMap[i][j]) {
                    case 'S' -> {
                        nextRoute.add(new Integer[]{i, j});
                        route[i][j] = 0;
                    }
                    case '*' -> {
                        nextFlood.add(new Integer[]{i, j});
                        water[i][j] = 0;
                    }
                }
            }
        }
        flood(nextFlood);
        System.out.println(evacuate(nextRoute));
    }

    private static void setArray() {
        water = new int[r][c];
        route = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(water[i], -1);
            Arrays.fill(route[i], -1);
        }
    }

    private static void flood(Queue<Integer[]> queue) {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (worldMap[nr][nc] == 'D' || worldMap[nr][nc] == 'X' || water[nr][nc] != -1) {
                    continue;
                }
                water[nr][nc] = water[now[0]][now[1]] + 1;
                queue.add(new Integer[]{nr, nc});
            }
        }
    }

    private static String evacuate(Queue<Integer[]> queue) {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (worldMap[now[0]][now[1]] == 'D') {
                return Integer.toString(route[now[0]][now[1]]);
            }

            int time = route[now[0]][now[1]] + 1;
            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c || worldMap[nr][nc] == 'X') {
                    continue;
                }
                if ((water[nr][nc] != -1 && water[nr][nc] <= time) || route[nr][nc] != -1) {
                    continue;
                }
                route[nr][nc] = time;
                queue.add(new Integer[]{nr, nc});
            }
        }
        return "KAKTUS";
    }
}
