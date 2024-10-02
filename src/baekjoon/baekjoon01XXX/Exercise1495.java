package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] volume = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i-1][j]) {
                    if (j+volume[i-1] >= 0 && j+volume[i-1] <= m) {
                        dp[i][j+volume[i-1]] = true;
                    }
                    if (j-volume[i-1] >= 0 && j-volume[i-1] <= m) {
                        dp[i][j-volume[i-1]] = true;
                    }
                }
            }
        }
        System.out.println(IntStream.iterate(m, i -> i >= 0, i -> i-1)
                .filter(i -> dp[n][i])
                .findFirst()
                .orElse(-1));
    }
}
