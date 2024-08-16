package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4097 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[] maxSum = new int[n];
            maxSum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                maxSum[i] = Math.max(maxSum[i-1]+arr[i], arr[i]);
            }
            System.out.println(Arrays.stream(maxSum).reduce(Integer.MIN_VALUE, Integer::max));
        }
    }
}
