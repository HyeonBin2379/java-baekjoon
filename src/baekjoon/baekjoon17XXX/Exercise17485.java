package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17485 {

    private static int n;
    private static int[][][] dp;
    private static final int INF = (int) 1e9;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());
        int[][] space = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            space[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[0][i], space[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + space[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + space[i][j];
                } else if (j == m-1) {
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + space[i][j];
                    dp[i][j][1] = dp[i-1][j][2] + space[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + space[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + space[i][j];
                }
            }
        }
        int min = IntStream.rangeClosed(0, m-1)
                .flatMap(i -> IntStream.rangeClosed(0, 2).map(j -> dp[n-1][i][j]))
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(min);
    }
}
