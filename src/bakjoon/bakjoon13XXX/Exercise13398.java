package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int[] left = new int[len];
        left[0] = array[0];
        int result = left[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(array[i], left[i-1]+array[i]);
            result = Math.max(result, left[i]);
        }
        int[] right = new int[len];
        right[len-1] = array[len-1];
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(array[i], right[i+1]+array[i]);
        }

        for (int i = 1; i < len-1; i++) {
            int temp = left[i-1] + right[i+1];
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }
}
