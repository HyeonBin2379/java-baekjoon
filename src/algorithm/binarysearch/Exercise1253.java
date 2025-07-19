package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise1253 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(IntStream.range(0, n)
                .filter(idx -> targetFound(n, idx))
                .count());
    }

    private static boolean targetFound(int len, int targetIdx) {
        int left = 0;
        int right = len-1;

        while (left < right) {
            // 시작 위치가 타겟의 위치와 같은 경우, 위치를 변경
            if (left == targetIdx) {
                left++;
                continue;
            }
            if (right == targetIdx) {
                right--;
                continue;
            }

            // 두 수의 합이 되는 타겟 탐색
            int sum = arr[left]+arr[right];
            if (sum == arr[targetIdx]) {
                return true;
            } else if (sum < arr[targetIdx]) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
