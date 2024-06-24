package bakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Exercise17103 {

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
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int evenNumber = sc.nextInt();
            List<Integer> sieve = new Sieve().getPrimeNumber(evenNumber);
            int[] primeNumber = sieve.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            int start = 0, end = primeNumber.length-1;
            int count = 0;
            while (start <= end) {
                if (primeNumber[start]+primeNumber[end] > evenNumber) {
                    end--;
                }
                else if (primeNumber[start]+primeNumber[end] < evenNumber) {
                    start++;
                }
                else {
                    start++;
                    end--;
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
