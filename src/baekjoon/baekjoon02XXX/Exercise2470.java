package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] solutions = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        int start = 0, end = n-1;
        long min = Long.MAX_VALUE;
        long first = 0, second = 0;
        while (start < end) {
            long sum = solutions[start] + solutions[end];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                first = solutions[start];
                second = solutions[end];
                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(first + " " + second);
    }
}
