package bakjoon.bakjoon16XXX;

import java.util.Scanner;

public class Exercise16723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = 2*n;
        for (long i = 1; n / 2 > 0; i++, n /= 2) {
            answer += (1L << i) * (n / 2);
        }
        System.out.println(answer);
    }
}
