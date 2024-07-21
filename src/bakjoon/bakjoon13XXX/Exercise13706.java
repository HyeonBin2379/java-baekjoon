package bakjoon.bakjoon13XXX;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13706 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger num = new BigInteger(sc.nextLine());

        BigInteger left = BigInteger.ZERO;
        BigInteger right = num;
        while (left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            if (mid.pow(2).compareTo(num) == 0) {
                System.out.println(mid);
                return;
            } else if (mid.pow(2).compareTo(num) < 0) {
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }
    }
}
