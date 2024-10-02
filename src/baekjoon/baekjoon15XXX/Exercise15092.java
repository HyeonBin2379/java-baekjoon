package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise15092 {

    private static int m, n;
    private static char[][] petriDish;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        petriDish = new char[m][n];
        for (int i = 0; i < m; i++) {
            petriDish[i] = br.readLine().toCharArray();
        }

        int loopCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (petriDish[i][j] == '#') {
                    loopCount++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(loopCount);
    }

    private static void dfs(int r, int c) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{r, c});

        while (!stack.isEmpty()) {
            Integer[] now = stack.pop();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (petriDish[nr][nc] == '#') {
                    petriDish[nr][nc] = '.';
                    stack.push(new Integer[]{nr, nc});
                }
            }
        }
    }
}
