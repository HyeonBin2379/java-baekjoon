package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1654 {

    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(upperBound(arr[k-1], k, n));
    }

    private static long upperBound(long maxLen, int n, long needed) {
        long low = 1;
        long high = maxLen;

        while (low < high) {
            long mid = (low+high+1)/2;
            long count = 0;

            for (int i = 0; i < n; i++) {
                count += (arr[i] / mid);
            }

            if (count >= needed) {
                low = mid;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
