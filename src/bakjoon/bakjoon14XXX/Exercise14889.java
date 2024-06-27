package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14889 {

    private static int n;
    private static int minDiff = Integer.MAX_VALUE;
    private static int[][] status;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        status = new int[n][n];
        for (int i = 0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        visited = new boolean[n];
        backtracking(0, 0);
        System.out.println(minDiff);
    }

    private static void backtracking(int num, int count) {
        if (count == n/2) {
            getDiff();
            return;
        }

        for (int i = num; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i+1, count+1);
                visited[i] = false;
            }
        }
        if (minDiff == 0) {
            System.out.println(minDiff);
            System.exit(0);
        }
    }

    private static void getDiff() {
        int start = 0, link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += (status[i][j] + status[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    link += (status[i][j] + status[j][i]);
                }
            }
        }
        minDiff = Math.min(Math.abs(start-link), minDiff);
    }
}