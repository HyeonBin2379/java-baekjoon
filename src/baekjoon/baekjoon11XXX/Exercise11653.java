package baekjoon.baekjoon11XXX;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise11653 {

    private static List<Integer> primeNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        setPrimeNum(num);
        for (int primeNum : primeNumbers) {
            if (num == 1) {
                break;
            }
            while (num % primeNum == 0) {
                System.out.println(primeNum);
                num /= primeNum;
            }
        }
    }

    private static void setPrimeNum(int num) {
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;

        for (int i = 2; i*i <= num; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= num; j += i) {
                isPrime[j] = false;
            }
        }

        primeNumbers = IntStream.rangeClosed(2, num)
                .filter(value -> isPrime[value]).boxed()
                .collect(Collectors.toList());
    }
}
