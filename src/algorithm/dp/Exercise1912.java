package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = Long.MIN_VALUE;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (i == 0) ? arr[0] : Math.max(dp[i-1]+arr[i], arr[i]);
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
