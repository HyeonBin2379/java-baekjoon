package bakjoon.bakjoon4XXX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise4948 {

    private static class Sieve {
        private final List<Integer> result = new ArrayList<>();
        public List<Integer> getPrimeNumber(int num) {
            boolean[] sieve = new boolean[num+1];
            Arrays.fill(sieve, true);

            for (int i = 2; i <= num; i++) {
                if (!sieve[i]) {
                    continue;
                }

                for (int j = 2*i; j <= num; j += i) {
                    sieve[j] = false;
                }
            }

            for (int i = 2; i <= num; i++) {
                if (sieve[i]) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int number = sc.nextInt();
            if (number == 0) {
                break;
            }

            List<Integer> sieve = new Sieve().getPrimeNumber(2*number);
            int[] primeNumber = sieve.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            int start = 0, end = primeNumber.length-1;
            while (primeNumber[start] <= number) {
                start++;
            }
            while (primeNumber[end] > number*2) {
                end++;
            }

            int count = end - start + 1;

            System.out.println(count);
        }
        sc.close();
    }
}
