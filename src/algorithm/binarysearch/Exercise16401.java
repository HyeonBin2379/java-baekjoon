package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16401 {

    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).sorted().toArray();

        System.out.println(lowerBound(arr[n-1], m));
    }

    private static long lowerBound(long maxLen, int needed) {
        long result = 0;
        long low = 1;
        long high = maxLen;

        while (low <= high) {
            long mid = (low+high) / 2;
            long sum = Arrays.stream(arr).map(cookie -> cookie/mid).sum();

            if (sum >= needed) {
                result = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }
}
