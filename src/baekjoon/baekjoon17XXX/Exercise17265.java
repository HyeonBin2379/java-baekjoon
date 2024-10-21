package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise17265 {

    private static final int[][] move = {{1, 0}, {0, 1}};
    private static final List<String> path = new ArrayList<>();

    private static int n, max, min;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        path.add(map[0][0]);
        dfs(0, 0);
        System.out.println(max + " " + min);
    }

    private static void dfs(int row, int col) {
        if (row == n-1 && col == n-1) {
            int result = getResult();
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        for (int[] ints : move) {
            int nr = row + ints[0];
            int nc = col + ints[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            path.add(map[nr][nc]);
            dfs(nr, nc);
            path.remove(path.size()-1);
        }
    }

    private static int getResult() {
        int result = Integer.parseInt(path.get(0));
        for (int i = 1; i < path.size(); i += 2) {
            switch (path.get(i)) {
                case "-" -> result -= Integer.parseInt(path.get(i + 1));
                case "+" -> result += Integer.parseInt(path.get(i + 1));
                case "*" -> result *= Integer.parseInt(path.get(i + 1));
            }
        }
        return result;
    }
}
