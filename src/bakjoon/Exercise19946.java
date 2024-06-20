package bakjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise19946 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger num = new BigInteger(sc.nextLine());
        int answer = 64;
        while (num.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            num = num.divide(BigInteger.TWO);
            answer--;
        }
        System.out.println(answer);
    }
}
