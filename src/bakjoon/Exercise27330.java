package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27330 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += score[i];
            if (isAnyMatched(num, sum)) {
                sum = 0;
            }
        }
        System.out.println(sum);
    }

    public static boolean isAnyMatched(int[] num, int val) {
        return Arrays.stream(num).anyMatch(value -> value == val);
    }
}
