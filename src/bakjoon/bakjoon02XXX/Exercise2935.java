package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num1 = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger num2 = new BigInteger(br.readLine());
        System.out.println((operator.equals("+")) ? num1.add(num2).toString() : num1.multiply(num2).toString());
    }
}
