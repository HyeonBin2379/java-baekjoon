package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger mul1 = BigInteger.ONE;
        BigInteger mul2 = BigInteger.ONE;
        for (int i = 1; i <= m.intValue(); i++) {
            mul1 = mul1.multiply(n.add(BigInteger.ONE).subtract(BigInteger.valueOf(i)));
            mul2 = mul2.multiply(BigInteger.valueOf(i));
        }
        System.out.println(mul1.divide(mul2));
    }
}
