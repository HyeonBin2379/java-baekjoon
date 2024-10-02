package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] weightLimit = new long[n];
        for (int i = 0; i < n; i++) {
            weightLimit[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weightLimit);

        long max = weightLimit[n-1];
        for (int i = n-1; i >= 0; i--) {
            max = Math.max(weightLimit[i]*(n-i), max);
        }
        System.out.println(max);
    }
}
