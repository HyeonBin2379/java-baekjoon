package algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17182 {

    private static int answer = (int)1e9;
    private static boolean[] checked;
    private static int[][] space;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        space = new int[n][n];
        for (int i = 0; i < n; i++) {
            space[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (space[i][j] > space[i][k]+ space[k][j]) {
                        space[i][j] = space[i][k]+ space[k][j];
                    }
                }
            }
        }

        checked = new boolean[n];
        checked[start] = true;
        backtracking(start, 1, 0);
        System.out.println(answer);
    }

    private static void backtracking(int cur, int visitedCnt, int cost) {
        if (visitedCnt == checked.length) {
            answer = Math.min(cost, answer);
            return;
        }
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                backtracking(i, visitedCnt+1, cost+ space[cur][i]);
                checked[i] = false;
            }
        }
    }
}
