package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n][2];
        for (int i = 0; i < n; i++) {
            schedule[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            for (int j = i+schedule[i][0]; j < n+1; j++) {
                dp[j] = Math.max(dp[i]+schedule[i][1], dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
