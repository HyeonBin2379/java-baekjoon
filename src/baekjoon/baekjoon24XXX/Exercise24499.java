package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise24499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefixSum = new int[2*n+1];
        for (int i = 1; i <= 2*n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[(i-1) % n];
        }

        int max = 0;
        for (int i = 0; i <= 2*n-k; i++) {
            max = Math.max(prefixSum[i+k]-prefixSum[i], max);
        }
        System.out.println(max);
    }
}
