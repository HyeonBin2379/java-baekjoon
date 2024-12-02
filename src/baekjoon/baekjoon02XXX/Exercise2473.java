package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] solutions = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long[] answer = new long[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            int start = i+1;
            int end = n-1;

            while (start < end) {
                long sum = solutions[i] + solutions[start] + solutions[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer = new long[] {solutions[i], solutions[start], solutions[end]};
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
        }
        System.out.println(Arrays.stream(answer).mapToObj(Long::toString).collect(Collectors.joining(" ")));
    }
}
