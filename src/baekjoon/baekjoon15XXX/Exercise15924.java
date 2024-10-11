package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15924 {

    private static final int MOD = (int)1e9+9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        for (int i = n -1; i >= 0; i--) {
            for (int j = m -1; j >= 0; j--) {
                if (i-1 >= 0 && (map[i-1][j] == 'S' || map[i-1][j] == 'B')) {
                    dp[i-1][j] = (dp[i-1][j] + dp[i][j] % MOD) % MOD;
                }
                if (j-1 >= 0 && (map[i][j-1] == 'E' || map[i][j-1] == 'B')) {
                    dp[i][j-1] = (dp[i][j-1] + dp[i][j] % MOD) % MOD;
                }
                answer = (answer + dp[i][j] % MOD) % MOD;
            }
        }
        System.out.println(answer % MOD);
    }
}
