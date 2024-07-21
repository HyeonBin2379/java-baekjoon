package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17266 {
    private static int[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        light = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();
        binarySearch(n, n);
    }

    private static void binarySearch(int right, int n) {
        int answer = 0;
        int left = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canLight(mid, n)) {
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }

    private static boolean canLight(int height, int n) {
        int prev = 0;
        for (int j : light) {
            if (j - height > prev) {
                return false;
            }
            prev = j + height;
        }
        return n-prev <= 0;
    }
}
