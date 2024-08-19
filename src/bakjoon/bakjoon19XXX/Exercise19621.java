package bakjoon.bakjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise19621 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] participants = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            participants[i] = count;
        }

        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            // i번째 회의를 진행할 때의 인원 수
            // i번째 회의를 포함하지 않으면 dp[i-1], 포함하면 dp[i-2]+arr[i]
            // (i번째 회의 포함 시 그 직전, 직후 회의는 제외해야 하기 때문)
            switch (i) {
                case 0 -> dp[0] = participants[0];
                case 1 -> dp[1] = Math.max(participants[0], participants[1]);
                default -> dp[i] = Math.max(dp[i - 1], dp[i - 2] + participants[i]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
