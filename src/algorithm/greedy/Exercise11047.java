package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[10];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins); // 동전의 금액을 내림차순으로 정렬

        // 동전의 금액이 큰 것부터 내림차순으로 금액을 차감
        int answer = 0;
        for (int i = 9; i >= 0; i--) {
            if (coins[i] == 0) {
                continue;
            }
            // 현재 금액이 동전의 금액보다 크거나 같을 때 해당 금액에서의 동전 개수를 총 개수에 추가
            if (k >= coins[i]) {
                int q = k/coins[i];
                k -= q*coins[i];
                answer += q;
            }
        }
        System.out.println(answer);
    }
}
