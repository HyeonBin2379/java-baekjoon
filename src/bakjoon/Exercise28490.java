package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise28490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger count = new BigInteger(br.readLine());

        BigInteger result = BigInteger.ZERO;
        while (!count.equals(BigInteger.ZERO)) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger h = new BigInteger(st.nextToken());
            BigInteger w = new BigInteger(st.nextToken());
            result = result.max(w.multiply(h));
            count = count.subtract(BigInteger.ONE);
        }
        System.out.println(result.toString());
    }
}
