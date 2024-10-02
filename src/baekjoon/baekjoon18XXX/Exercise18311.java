package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18311 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] dist = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();

        long[] prefixSum = new long[2*n+1];
        for (int i = 1; i <= 2*n; i++) {
            if (i <= n) {
                prefixSum[i] = prefixSum[i-1] + dist[i-1];
            } else {
                prefixSum[i] = prefixSum[i-1] + dist[2*n-i];
            }
            if (prefixSum[i-1] <= k && k < prefixSum[i]) {
                System.out.println((i <= n) ? i : 2*n+1-i);
                break;
            }
        }
    }
}
