package bakjoon.bakjoon1XXX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] primeNumber = sieve(number);
        int[] prefixSum = new int[primeNumber.length+1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + primeNumber[i-1];
        }

        int count = 0;
        int start = 1, end = 1;
        while (end < prefixSum.length) {
            if (prefixSum[end]-prefixSum[start-1] > number) {
                start++;
            }
            else if (prefixSum[end]-prefixSum[start-1] < number){
                end++;
            }
            else {
                count++;
                start++;
                end++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static int[] sieve(int num) {
        boolean[] sieve = new boolean[num+1];
        List<Integer> result = new ArrayList<>();
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
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
