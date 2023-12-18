package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2342 {
    private static final int[][] movingPower = {
            {0, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3}, {2, 3, 4, 3, 1}
    };
    private static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][][] dp = new int[100001][5][5];
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        int start = 1;
        dp[0][0][0] = 0;
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());

            if (next == 0) {
                break;
            }
            for (int i = 0; i < 5; i++) {
                if (next == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    dp[start][i][next] = Math.min(dp[start-1][i][j]+movingPower[j][next], dp[start][i][next]);
                }
            }
            for (int i = 0; i < 5; i++) {
                if (next == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    dp[start][next][i] = Math.min(dp[start-1][j][i]+movingPower[next][j], dp[start][next][i]);
                }
            }
            start++;
        }
        br.close();

        int result = MAX;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, dp[start-1][i][j]);
            }
        }
        System.out.println(result);
    }
}
