package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14620 {

    private static int n, result;
    private static int[][] garden;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        garden = new int[n][n];
        for (int i = 0; i < n; i++) {
            garden[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][n];
        result = Integer.MAX_VALUE;
        backtracking(0, 0);
        System.out.println(result);
    }

    private static void backtracking(int count, int total) {
        if (count == 3) {
            result = Math.min(total, result);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPromised(i, j)) {
                    int sum = garden[i][j];
                    for (int[] ints : move) {
                        int nr = i + ints[0];
                        int nc = j + ints[1];
                        visited[nr][nc] = true;
                        sum += garden[nr][nc];
                    }
                    visited[i][j] = true;

                    backtracking(count+1, total+sum);

                    visited[i][j] = false;
                    for (int[] ints : move) {
                        int nr = i + ints[0];
                        int nc = j + ints[1];
                        visited[nr][nc] = false;
                        sum += garden[nr][nc];
                    }
                }
            }
        }
    }

    private static boolean isPromised(int r, int c) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                return false;
            }
        }
        return true;
    }
}
