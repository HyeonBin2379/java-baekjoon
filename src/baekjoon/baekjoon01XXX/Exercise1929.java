package baekjoon.baekjoon01XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] isPrime = new boolean[b+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;
        for (int i = 2; i*i <= b; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= b; j += i) {
                isPrime[j] = false;
            }
        }
        IntStream.rangeClosed(a, b).filter(idx -> isPrime[idx]).forEach(System.out::println);
    }
}
