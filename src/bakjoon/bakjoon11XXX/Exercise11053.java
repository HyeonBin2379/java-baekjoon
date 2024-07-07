package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
