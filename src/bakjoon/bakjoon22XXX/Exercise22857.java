package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise22857 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i= 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp: i번째 숫자에서의 삭제 횟수가 j번 남았을 때의 짝수 연속 부분 수열의 길이
        // dp 배낭 문제 응용
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // i번째 수가 짝수일 경우
                if (arr[i] % 2 == 0) {
                    dp[i][j] = dp[i-1][j] + 1;
                }
                // i번째 수가 홀수이면서 삭제 횟수가 남은 경우
                else if (arr[i] % 2 == 1 && j > 0) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        // 구한 짝수 연속 부분 수열 길이 중 최댓값 찾기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int max = Arrays.stream(dp[i]).reduce(0, Integer::max);
            answer = Math.max(max, answer);
        }
        System.out.println(answer);
    }
}
