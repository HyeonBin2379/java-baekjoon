package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25214 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        int[] num = new int[len+1];
        int[] dp = new int[len+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            min = Math.min(num[i], min);
            dp[i] = Math.max(dp[i-1], num[i]-min);
        }
        for (int i = 1; i <= len; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}
