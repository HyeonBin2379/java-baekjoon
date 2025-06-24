package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2295 {

    private static List<Long> sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum.add(arr[i]+arr[j]);
            }
        }
        sum = sum.stream().sorted().collect(Collectors.toList());

        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (contains(arr[i]-arr[j], sum.size())) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    private static boolean contains(long target, int size) {
        int left = 0;
        int right = size-1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (sum.get(mid) == target) {
                return true;
            } else if (sum.get(mid) < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
