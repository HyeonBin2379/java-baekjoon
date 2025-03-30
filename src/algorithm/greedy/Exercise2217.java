package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] weights = new long[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(weights);

        long maxWeight = 0L;
        for (int i = n-1; i >= 0; i--) {
            maxWeight = Math.max(weights[i]*(n-i), maxWeight);
        }
        System.out.println(maxWeight);
    }
}
