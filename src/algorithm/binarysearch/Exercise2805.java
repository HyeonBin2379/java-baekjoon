package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2805 {

    private static long[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        height = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        System.out.println(upperBound(height[n-1], m));
    }

    private static long upperBound(long maxLen, long totalLen) {
        long low = 0;
        long high = maxLen;

        while (low < high) {
            long mid = (low + high + 1) / 2;
            long sum = Arrays.stream(height).filter(tree -> tree > mid).map(tree -> tree-mid).sum();

            if (sum >= totalLen) {
                low = mid;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
