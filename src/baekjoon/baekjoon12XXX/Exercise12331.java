package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise12331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());   // 최대 및 초기 에너지량
            int r = Integer.parseInt(st.nextToken());   // 활동 후 회복량
            int n = Integer.parseInt(st.nextToken());   // 계획한 활동의 수

            // 활동별 중요도
            long[] v = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long[][] dp = new long[n+1][e+1];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= e; k++) {
                    // 현재 에너지로 j번째 활동을 하지 않는 경우
                    dp[j+1][k] = Math.max(dp[j+1][k], dp[j][k]);

                    // 현재 에너지로 j번째 활동을 하는 경우
                    for (int spend = 0; spend <= k; spend++) {
                        long gain = spend * v[j];
                        int newEnergy = Math.min(e, k-spend+r);
                        dp[j+1][newEnergy] = Math.max(dp[j+1][newEnergy], dp[j][k]+gain);
                    }
                }
            }
            // 에너지 관리 과정에서 얻을 수 있는 최대 이득
            long max = IntStream.rangeClosed(0, e).mapToLong(idx -> dp[n][idx]).reduce(0, Long::max);
            sb.append(String.format("Case #%d: %d\n", i, max));
        }
        System.out.print(sb);
    }
}
