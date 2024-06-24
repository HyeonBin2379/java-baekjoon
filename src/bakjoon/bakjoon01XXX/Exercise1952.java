package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1952 {
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[m][n];

        int s_row = 0, s_col = 0;
        int dist = 0;
        int count = 0;
        for (int i = 0; i < m*n; i++) {
            visited[s_row][s_col] = true;
            s_row += dr[dist % 4];
            s_col += dc[dist % 4];

            if (s_row < 0 || s_col < 0 || s_row >= m || s_col >= n || visited[s_row][s_col]) {
                s_row += (dr[(dist+1) % 4] - dr[dist]);
                s_col += (dc[(dist+1) % 4] - dc[dist]);
                dist = (dist + 1) % 4;
                count++;
            }
        }
        System.out.println(count-1);
    }
}
