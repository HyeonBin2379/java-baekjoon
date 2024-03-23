package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise16428 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        if (num1.compareTo(BigInteger.ZERO) < 0 && num2.compareTo(BigInteger.ZERO) < 0) {
            System.out.println(num1.divide(num2).add(BigInteger.ONE));
            System.out.println(num1.remainder(num2).subtract(num2));
        } else if (num1.compareTo(BigInteger.ZERO) < 0 && num2.compareTo(BigInteger.ZERO) > 0) {
            System.out.println(num1.divide(num2).subtract(BigInteger.ONE));
            System.out.println(num1.remainder(num2).add(num2));
        } else {
            System.out.println(num1.divide(num2));
            System.out.println(num1.remainder(num2));
        }
    }
}
