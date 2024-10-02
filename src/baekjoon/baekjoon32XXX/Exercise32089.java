package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise32089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] prefixSum = new int[n+1];
            IntStream.rangeClosed(1, n).forEach(i -> prefixSum[i] = prefixSum[i-1]+arr[i-1]);
            IntStream.rangeClosed(0, n-3).map(i -> prefixSum[i+3]-prefixSum[i]).max().ifPresent(System.out::println);
        }
    }
}
