package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18290 {

    private static int n, m, k, answer;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[n][m];
        answer = Integer.MIN_VALUE;
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static boolean isPromised(int row, int col) {
        for (int[] ints : move) {
            int nr = row + ints[0];
            int nc = col + ints[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc]) {
                return false;
            }
        }
        return true;
    }

    private static void backtracking(int sum, int count) {
        if (count == k) {
            answer = Math.max(sum, answer);
            return;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!visited[i][j] && isPromised(i, j)) {
                    visited[i][j] = true;
                    backtracking(sum + arr[i][j], count+1);
                    visited[i][j] = false;
                }
            }
        }
    }
}
