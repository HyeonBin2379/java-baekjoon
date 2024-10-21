package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise18249 {

    private static final int MOD = (int)1e9+7;
    private static final int[] dp = new int[191230];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        setAnswer();

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void setAnswer() {
        // dp[i-1] : 2*n개의 정점 중 조건에 맞는 두 정점을 잇는 간선 1개를 그릴 수 있는 i의 개수
        // dp[i-2] : 2*n개의 정점 중 조건에 맞게 교차하는 두 간선을 그릴 수 있는 i의 개수
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i <= 2 ? i : (dp[i-1] + dp[i-2]) % MOD;
            dp[i] %= MOD;
        }
    }
}