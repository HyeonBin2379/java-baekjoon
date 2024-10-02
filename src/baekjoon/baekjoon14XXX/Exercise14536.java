package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] t = new int[n];   // 벽돌의 두께
            int[] w = new int[n];   // 벽돌의 너비

            int total = 0;  // 모든 벽돌의 두께의 합
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
                total += t[i];
            }

            // 수평으로 1번, 수직으로 1번씩 j번 벽돌을 놓았을 때, 벽의 가로 길이
            int[] dp = new int[total+1];
            for (int i = 0; i < n; i++) {
                for (int j = total; j >= t[i]+w[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-(t[i]+w[i])]+t[i]);
                }
            }

            // 벽의 세로 길이의 최솟값
            System.out.println(total-dp[total]);
        }
    }
}
