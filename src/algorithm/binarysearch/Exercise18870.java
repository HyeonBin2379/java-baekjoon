package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise18870 {

    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        sorted = Arrays.stream(arr).distinct().sorted().toArray();

        for (int i = 0; i < n; i++) {
            int cnt = lowerBound(arr[i], sorted.length);
            bw.write(cnt + " ");
        }
        bw.close();
    }

    private static int lowerBound(int target, int size) {
        int left = 0;
        int right = size-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sorted[mid] == target) {
                return mid;
            } else if (sorted[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
