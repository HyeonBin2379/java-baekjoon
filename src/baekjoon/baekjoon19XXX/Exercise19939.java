package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise19939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[k+1];
        IntStream.rangeClosed(1, k).forEach(index -> {
            prefixSum[index] = prefixSum[index-1]+index;
        });

        if (n < prefixSum[k]) {
            System.out.println(-1);
            return;
        }
        n -= prefixSum[k];  // n - {k*(k+1)/2}

        // (n-k*(k+1)/2)가 k로 나누어 떨어지면 동일한 개수만큼 모든 바구니에 공 분배 가능: 최소 차는 불변
        if (n % k == 0) {
            System.out.println(k-1);
        }
        // k로 나누어 떨어지지 않으면 최대 개수부터 적은 순으로 공을 분배
        // 나머지가 k-1일 때 차가 최소가 되며, 이 경우 최소 개수의 바구니만 공을 분배받지 못함
        // 따라서 최대 개수와 최소 개수의 차의 최솟값은 k
        else {
            System.out.println(k);
        }
    }
}
