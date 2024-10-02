package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28777 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            // 기본적으로 현재 존재를 촬영하기 위해서는 최소 1장의 사진이 필요
            dp[i] = dp[i - 1] + 1;

            // 2명의 존재를 촬영할 수 있는 경우
            if (heights[i] - heights[i - 1] <= 20) {
                dp[i] = Math.min(dp[i], (i > 1 ? dp[i - 2] : 0) + 1);
            }

            // 3명의 존재를 촬영할 수 있는 경우
            if (i > 1 && heights[i] - heights[i - 2] <= 10) {
                dp[i] = Math.min(dp[i], (i > 2 ? dp[i - 3] : 0) + 1);
            }
        }

        System.out.println(dp[n-1]);
    }
}
