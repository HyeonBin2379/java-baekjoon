package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+array[i], array[i]);
        }
        br.close();

        int max = dp[1];
        for (int i = 2; i < N+1; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
