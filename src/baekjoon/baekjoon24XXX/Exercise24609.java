package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n+1];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+Integer.parseInt(br.readLine());
            if (sum[i] < 0) {
                max = Math.max(Math.abs(sum[i]), max);
            }
        }

        System.out.println(max);
    }
}
