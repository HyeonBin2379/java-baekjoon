package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0]+ map[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1]+ map[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+map[i][j];
            }
        }
        System.out.println(dp[n -1][m -1]);
    }
}
