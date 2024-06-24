package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1926 {
    private static int[][] paper;
    private static boolean[][] visited;

    private static int row, col;
    private static int count = 0;
    private static final int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        paper = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        if (row == 0 && col == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count = 0;
                if (!visited[i][j] && paper[i][j] == 1) {
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        if (!answer.isEmpty()) {
            System.out.println(answer.size());
            System.out.println(Collections.max(answer));
        } else {
            System.out.println(0);
            System.out.println(0);
        }
    }

    public static void dfs(int s_row, int s_col) {
        visited[s_row][s_col] = true;
        count++;
        for (int[] nextMove : move) {
            int n_row = s_row + nextMove[0];
            int n_col = s_col + nextMove[1];
            if (n_row >= 0 && n_row < row && n_col >= 0 && n_col < col
                    && !visited[n_row][n_col] && paper[n_row][n_col] == 1) {
                dfs(n_row, n_col);
            }
        }
    }
}
