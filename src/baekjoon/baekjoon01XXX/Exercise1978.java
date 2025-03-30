package baekjoon.baekjoon01XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        boolean[] isPrime = new boolean[numbers[n-1] + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;
        for (int i = 2; i*i <= numbers[n-1]; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= numbers[n-1]; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        System.out.println(Arrays.stream(numbers).filter(value -> isPrime[value]).count());
    }
}
