package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise23257 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        boolean[][] dp = new boolean[n+1][1024];
        for (int i = 0; i < n; i++) {
            num[i] = Math.abs(Integer.parseInt(st.nextToken()));
            dp[1][num[i]] = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 1024; j++) {
                if (!dp[i][j]) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    dp[i+1][j ^ num[k]] = true;
                }
            }
        }
        for (int i = 1023; i >= 0; i--) {
            if (dp[m][i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
