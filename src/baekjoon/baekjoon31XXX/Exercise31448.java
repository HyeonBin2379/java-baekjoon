package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] height = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long[] gratitude = new long[n];
        long max = 0;
        for (int i = 1; i < n; i++) {
            if (height[i] >= height[i-1]) {
                gratitude[i] = gratitude[i-1] + (height[i]-height[i-1]);
                max = Math.max(gratitude[i], max);
            }
        }
        System.out.println(max);
    }
}
