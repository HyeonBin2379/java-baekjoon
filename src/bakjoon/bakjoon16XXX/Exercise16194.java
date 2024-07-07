package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pack = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pack[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int newCost = dp[i-j]+pack[j];
                dp[i] = (dp[i] == 0) ? newCost : Math.min(newCost, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
