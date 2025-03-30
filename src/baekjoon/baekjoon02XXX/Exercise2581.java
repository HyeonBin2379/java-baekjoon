package baekjoon.baekjoon02XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;

        for (int i = 2; i*i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        int minPrime = n;
        int total = 0;
        for (int i = n; i >= m; i--) {
            if (isPrime[i]) {
                total += i;
                minPrime = i;
            }
        }

        if (total == 0) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(minPrime);
        }
    }
}