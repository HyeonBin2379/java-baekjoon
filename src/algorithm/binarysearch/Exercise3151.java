package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3151 {

    private static long[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        score = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                long sum = score[i]+score[j];
                long left = lowerBound(j+1, n, -sum);
                long right = upperBound(j+1, n, -sum);
                count += (right-left);
            }
        }
        System.out.println(count);
    }

    // 인덱스 범위의 시작값 탐색
    private static int lowerBound(int left, int right, long target) {
        while (left < right) {
            int mid = (left+right) / 2;

            if (score[mid] >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    // 인덱스 범위의 끝값 탐색
    private static int upperBound(int left, int right, long target) {
        while (left < right) {
            int mid = (left+right) / 2;

            if (score[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
