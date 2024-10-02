package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise6980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                int[] input = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
                int[] sorted = input.clone();
                Arrays.sort(sorted);
                System.out.printf("Optimal train swapping takes %d swaps.\n", getCount(input, sorted, n));
            } else {
                System.out.printf("Optimal train swapping takes %d swaps.\n", 0);
            }
        }
    }

    private static int getCount(int[] arr, int[] sorted, int len) {
        int count = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (Arrays.equals(arr, sorted)) {
                    return count;
                }
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
