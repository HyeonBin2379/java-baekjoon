package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2473 {

    private static long best = Long.MAX_VALUE;
    private static long[] ph, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ph = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                if (isSumZero(i, j, n)) {
                    return;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    private static boolean isSumZero(int first, int second, int n) {
        int left = second+1;
        int right = n-1;

        while (left <= right) {
            int mid = (left+right)/2;
            long sum = ph[first]+ph[mid]+ph[second];

            if (best > Math.abs(sum)) {
                best = Math.abs(sum);
                answer = new long[] {ph[first], ph[second], ph[mid]};
            }

            if (sum < 0) {
                left = mid+1;
            } else if (sum > 0) {
                right = mid-1;
            } else {
                System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                return true;
            }
        }
        return false;
    }
}