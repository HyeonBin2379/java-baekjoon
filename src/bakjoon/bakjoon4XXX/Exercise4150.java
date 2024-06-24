package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise4150 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] fib = {BigInteger.ZERO, BigInteger.ONE};
        for (int i = 2; i <= n; i++) {
            BigInteger temp = fib[0].add(fib[1]);
            fib[0] = fib[1];
            fib[1] = temp;
        }
        System.out.println(fib[1]);
    }
}
