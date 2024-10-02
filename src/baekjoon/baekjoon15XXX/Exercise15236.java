package baekjoon.baekjoon15XXX;

import java.util.Scanner;

public class Exercise15236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        for (long i = 0; i <= n; i++) {
            for (long j = 0; j <= i; j++) {
                sum += (i+j);
            }
        }
        System.out.println(sum);
    }
}
