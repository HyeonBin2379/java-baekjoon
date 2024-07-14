package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10211 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] prefixSum = new int[n+1];
            for (int i = 1; i <= n; i++) {
                int value = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i-1]+value;
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    int subSum = prefixSum[j]-prefixSum[i-1];
                    max = Math.max(subSum, max);
                }
            }
            System.out.println(max);
        }
    }
}
