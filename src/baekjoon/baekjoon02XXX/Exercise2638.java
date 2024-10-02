package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise2638 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer[]> cheese;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cheese = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cheese.add(new Integer[]{i, j});
                }
            }
        }

        int time = 0;
        while (!cheese.isEmpty()) {
            visited = new boolean[n][m];
            countSide(0, 0);
            melting();
            time++;
        }
        System.out.println(time);
    }

    private static void countSide(int r, int c) {
        visited[r][c] = true;
        map[r][c] = 2;
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (!visited[nr][nc] && map[nr][nc] != 1) {
                countSide(nr, nc);
            }
        }
    }

    private static void melting() {
        for (int i = 0; i < cheese.size(); i++) {
            Integer[] now = cheese.get(i);
            int count = 0;

            for (int[] ints : move) {
                int nr = now[0]+ints[0];
                int nc = now[1]+ints[1];
                if (map[nr][nc] == 2) {
                    count++;
                }
            }
            if (count >= 2) {
                map[now[0]][now[1]] = 0;
                cheese.remove(i--);
            }
        }
    }
}
