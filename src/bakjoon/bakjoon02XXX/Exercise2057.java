package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise2057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger input = new BigInteger(br.readLine());

        BigInteger[] fact = new BigInteger[21];
        fact[0] = BigInteger.ONE;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }

        if (input.equals(BigInteger.ZERO)) {
            System.out.println("NO");
            return;
        }

        for (int i = 20; i >= 0; i--) {
            if (input.compareTo(fact[i]) >= 0) {
                input = input.subtract(fact[i]);
            }
        }
        System.out.println(input.equals(BigInteger.ZERO) ? "YES" : "NO");
    }
}
