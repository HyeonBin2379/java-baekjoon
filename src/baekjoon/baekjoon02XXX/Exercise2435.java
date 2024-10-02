package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[len+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + num;
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= len; i++) {
            int sum = prefixSum[i] - prefixSum[i-k];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
