package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1359 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        double answer = 0.0;
        double p = combination(n, m);
        while (m >= k) {
            if (n-m < m-k) {
                k++;
                continue;
            }
            answer += combination(m, k)*combination(n-m, m-k)/p;
            k++;
        }
        System.out.printf("%.9f\n", answer);
    }

    private static long combination(long n, long k) {
        long c = 1;
        long p = 1;
        while (k > 0) {
            c *= n--;
            p *= k--;
        }
        return c / p;
    }
}
