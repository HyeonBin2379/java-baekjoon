package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cost = initArray(br.readLine(), n);
        int[] joy = initArray(br.readLine(), n);

        // dp[i][j] : i번째 사람까지 만나서 체력이 j만큼 남았을 때의 최대 기쁨
        // 행과 열의 값이 커질수록 dp의 값이 증가
        int[][] dp = new int[n+1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                // i번째 사람과 인사를 주고받은 경우
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]]+joy[i], dp[i][j]);
                }
                // i번째 사람과 인사를 주고받지 않은 경우
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            }
        }
        // 체력을 모두 소모하지 않았을 때의 최대 기쁨 = 체력이 1 남았을 때의 최대 기쁨
        System.out.println(dp[n][99]);
    }

    private static int[] initArray(String input, int n) {
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
