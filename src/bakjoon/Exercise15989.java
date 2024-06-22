package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15989 {

    private static final long[][] dp = new long[10001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        calculate();
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
        }
        System.out.print(sb);
    }

    private static void calculate() {
        // 행: 1,2,3을 더했을 때의 합이 되는 정수, 열: 1,2,3 중 수식에서 마지막으로 사용된 값
        for (int i = 1; i <= 10000; i++) {
            if (i <= 3) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = 1;
                }
                continue;
            }
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
    }
}