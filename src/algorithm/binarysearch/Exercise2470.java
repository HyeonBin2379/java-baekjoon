package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2470 {

    private static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        findAnswer(n);
    }

    private static void findAnswer(int n) {
        int left = 0;
        int right = n-1;

        int minDist = Integer.MAX_VALUE;
        int leftVal = values[left];
        int rightVal = values[right];
        while (left < right) {
            int sum = values[left]+values[right];

            if (minDist > Math.abs(sum)) {
                minDist = Math.abs(sum);
                leftVal = values[left];
                rightVal = values[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(leftVal + " " + rightVal);
    }
}
