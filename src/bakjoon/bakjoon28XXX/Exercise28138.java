package bakjoon.bakjoon28XXX;

import java.util.Scanner;

public class Exercise28138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long r = sc.nextLong();

        long p = n-r;
        long sum = 0;
        for (long m = 1; m*m <= p; m++) {
            if (p % m == 0) {
                if (m > r) {
                    sum += m;
                }
                if (m*m != p && p/m > r) {
                    sum += p/m;
                }
            }
        }
        System.out.println(sum);
    }
}
