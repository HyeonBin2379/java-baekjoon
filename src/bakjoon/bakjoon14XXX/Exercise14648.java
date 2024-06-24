package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14648 {

    private static long[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            long[] prefixSum = getPrefixSum(num, n);
            switch (queryType) {
                case 1 -> {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    bw.write(prefixSum[b] - prefixSum[a - 1] + "\n");
                    swap(a, b);
                }
                case 2 -> {
                    int s1 = Integer.parseInt(st.nextToken());
                    int e1 = Integer.parseInt(st.nextToken());
                    int s2 = Integer.parseInt(st.nextToken());
                    int e2 = Integer.parseInt(st.nextToken());
                    bw.write((prefixSum[e1] - prefixSum[s1 - 1]) - (prefixSum[e2] - prefixSum[s2 - 1]) + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void swap(int i, int j) {
        long temp = num[i-1];
        num[i-1] = num[j-1];
        num[j-1] = temp;
    }
    private static long[] getPrefixSum(long[] num, int n) {
        long[] prefixSum = new long[num.length+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + num[i-1];
        }
        return prefixSum;
    }
}
