package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise12199 {

    private static final long[][] combine = new long[101][101];
    private static final long MOD = (long)(1e9 + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        setCombination();

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long answer = 0L;

            for (int i = 0; i < m; i++) {
                int sign = (i % 2 == 0) ? 1 : -1;
                long power = 1;
                for (int j = 0; j < n; j++) {
                    power = (power * (m-i)) % MOD;
                }

                // 더해지는 값이 음수인 경우에도 양수인 나머지를 구할 수 있도록 보정
                answer += (sign*power*combine[m][i] + MOD*100);
                answer %= MOD;
            }
            sb.append(String.format("Case #%d: %d\n", t, answer));
        }
        System.out.print(sb);
    }

    private static void setCombination() {
        IntStream.rangeClosed(0, 100).forEach(i -> combine[i][0] = 1);
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                combine[i][j] = (combine[i-1][j-1] + combine[i-1][j]) % MOD;
            }
        }
    }
}
