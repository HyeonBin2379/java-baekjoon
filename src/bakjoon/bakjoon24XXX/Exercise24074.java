package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(seq).max().getAsInt();
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (max == seq[i]) {
                index = i+1;
                break;
            }
        }

        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + seq[i-1];
        }
        System.out.println(prefixSum[index-1] - prefixSum[0]);
        System.out.println(prefixSum[n]-prefixSum[index]);
    }
}
