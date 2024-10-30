package baekjoon.baekjoon32XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise32585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] prefixSum = new long[n+1];
        IntStream.rangeClosed(1, n).forEach(idx -> prefixSum[idx] = prefixSum[idx-1]+idx);
        System.out.println(Arrays.stream(prefixSum).sum());
    }
}
