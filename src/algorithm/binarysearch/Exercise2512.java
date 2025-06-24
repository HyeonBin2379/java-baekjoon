package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2512 {

    private static long[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        budget = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).sorted().toArray();
        long target = Integer.parseInt(br.readLine());

        System.out.println(upperBound(budget[n-1], target));
    }

    private static long upperBound(long maxVal, long limit) {
        long left = 1;
        long right = maxVal;

        while (left < right) {
            long mid = (left+right+1)/2;
            long sum = Arrays.stream(budget).map(val -> Math.min(val, mid)).sum();

            if (sum <= limit) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
