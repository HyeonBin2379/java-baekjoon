package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalCost = Arrays.stream(cost).sum();

        // dp[i][j] : i번째 앱까지 탐색했을 때, 비용 j를 소모해 얻을 수 있는 최대 메모리
        int[][] dp = new int[n+1][totalCost+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalCost; j++) {
                // 앱 비활성화 시 손해 없음: 비활성화 시 얻을 수 있는 최대 메모리
                if (j >= cost[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j-cost[i-1]]+mem[i-1], dp[i][j]);
                }
                // 앱 활성화 유지 시 얻을 수 있는 최대 메모리
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            }
        }
        // 최소 비용으로 m byte 이상의 메모리를 확보할 때, 확보하게 되는 메모리 용량
        IntStream.rangeClosed(0, totalCost)
                .filter(i -> dp[n][i] >= m)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
