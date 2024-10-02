package baekjoon.baekjoon09XXX;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise9916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] factorial = new BigInteger[n+1];
        Arrays.fill(factorial, BigInteger.ONE);
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
        }
        int count = 0;
        BigInteger temp = factorial[n];
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = temp.mod(BigInteger.TEN);
            if (digit.equals(BigInteger.ZERO)) {
                count++;
            }
            temp = temp.divide(BigInteger.TEN);
        }
        System.out.println(count);
    }
}
