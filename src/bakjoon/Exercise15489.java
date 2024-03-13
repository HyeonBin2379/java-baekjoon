package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long[][] dp = new long[31][31];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i < dp.length-1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        long sum = 0;
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= i; j++) {
                sum += dp[i+r-1][j+c-1];
            }
        }
        System.out.println(sum);
    }
}
