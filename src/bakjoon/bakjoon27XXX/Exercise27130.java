package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise27130 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num1 = new BigInteger(br.readLine());
        BigInteger num2 = new BigInteger(br.readLine());

        System.out.println(num1);
        System.out.println(num2);
        int[] digit = Arrays.stream(num2.toString().split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = digit.length-1; i >= 0; i--) {
            System.out.println(num1.multiply(BigInteger.valueOf(digit[i])));
        }
        System.out.println(num1.multiply(num2));
    }
}
