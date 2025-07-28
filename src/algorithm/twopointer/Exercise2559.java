package algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long num = Integer.parseInt(st.nextToken());

            prefixSum[i] = prefixSum[i-1]+num;
        }

        long answer = Long.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            long sum = prefixSum[i]-prefixSum[i-k];

            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
