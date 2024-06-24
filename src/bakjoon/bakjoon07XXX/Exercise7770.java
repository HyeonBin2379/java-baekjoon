package bakjoon.bakjoon07XXX;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Exercise7770 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] floor = LongStream.rangeClosed(1, n)
                .map(num -> 2*num*num - 2*num + 1)
                .takeWhile(value -> value <= 1000000000)
                .toArray();

        long[] prefixSum = new long[floor.length + 1];
        int answer = 0;
        for (int i = 1; i <= floor.length; i++) {
            prefixSum[i] = prefixSum[i-1] + floor[i-1];
            if (prefixSum[i-1] < n && n <= prefixSum[i]) {
                answer = (prefixSum[i] == n) ? i : i-1;
                break;
            }
        }
        System.out.println(answer);
    }
}
