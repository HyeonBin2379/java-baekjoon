package algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1]+num;
        }

        int start = 0, end = 1;
        int answer = 0;
        while (start <= n && end <= n) {
            long sum = prefixSum[end]-prefixSum[start];
            if (sum == m) {
                answer++;
                end++;
            } else if (sum < m) {
                end++;
            } else {
                start++;
            }
        }
        System.out.println(answer);
    }
}
