package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise2294 {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = IntStream.rangeClosed(0, k).map(i -> (i == 0) ? 0 : INF).toArray();
        for (int i = 1; i <= n; i++) {
            // i번째 동전을 사용했을 시 j원을 만드는 경우의 수의 최솟값 구하기
            // dp[j] = (i번째 동전의 금액을 뺀 나머지 금액을 만드는 방법의 수+1)의 최솟값
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin[i]]+1, dp[j]);
            }
        }
        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}
