package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(num).sum();
        if (sum % 2 == 0) {
            System.out.println(sum);
            return;
        }

        int min = sum;
        for (int i = 0; i < len; i++) {
            if (num[i] % 2 == 1) {
                min = Math.min(num[i], min);
            }
        }
        System.out.println(Math.max(sum-min, 0));
    }
}
