package bakjoon.bakjoon31XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise31526 {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        // dp[i][j]는 i번째 열, j번째 행에 식물을 놓는 경우의 수
        long[][] dp = new long[c+1][r+1];

        // 첫 번째 열은 각 행별로 식물을 놓는 경우가 1가지씩 있음
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= c; i++) {
            long sum = 0;
            // 이전 열까지 가능한 모든 방법의 수를 계산
            for (int j = 1; j <= r; j++) {
                sum += (dp[i-1][j] % MOD);
            }
            for (int j = 1; j <= r; j++) {
                // 현재 열과 인접한 열이면서 행이 같은 경우는 모두 제외
                dp[i][j] = (sum - dp[i-1][j] + MOD) % MOD;
            }
        }

        // 마지막 열까지 조건을 만족했을 때, 모든 가짓수의 총합 계산
        long result = IntStream.rangeClosed(1, r).mapToLong(j -> dp[c][j] % MOD).reduce(0, Long::sum);
        System.out.println(result % MOD);
    }
}
