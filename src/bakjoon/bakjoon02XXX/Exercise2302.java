package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        // 각 좌석마다 자신의 바로 왼쪽 또는 오른쪽으로만 자리 변경 가능
        // 가능한 배치 방법의 가짓수는 피보나치 수열
        for (int i = 0; i <= n; i++) {
            dp[i] = (i < 2) ? 1 : dp[i-1] + dp[i-2];
        }

        // 고정석을 경계로 분할된 각각의 열에 인원을 배치하는 방법의 가짓수
        int answer = 1;
        int startRange = 1;
        while (m-- > 0) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - startRange];
            startRange = vip+1;
        }
        answer *= dp[n-startRange+1];
        System.out.println(answer);
    }
}
