package bakjoon.bakjoon8XXX;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise8741 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger num = BigInteger.TWO.pow(scanner.nextInt());
        BigInteger sum = num.multiply(num.subtract(BigInteger.ONE)).divide(BigInteger.TWO);
        System.out.println(sum.toString(2));
    }
}
