package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] prefixSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + num[i-1];
        }

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += num[i-1]*(prefixSum[n]-prefixSum[i]);
        }
        System.out.println(answer);
    }
}
