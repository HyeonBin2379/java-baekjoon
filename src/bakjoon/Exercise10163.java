package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise10163 {

    private static final int[][] board = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = r; j < r+h; j++) {
                for (int k = c; k < c+w; k++) {
                    board[j][k] = i;
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (board[i][j] > 0) {
                    answer[board[i][j] - 1]++;
                }
            }
        }
        Arrays.stream(answer).forEach(System.out::println);
    }
}
