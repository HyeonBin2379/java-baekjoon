package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise6976 {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            BigInteger num = new BigInteger(br.readLine());
            BigInteger origin = num;

            sb.append(num).append("\n");
            while (num.compareTo(BigInteger.valueOf(100)) >= 0) {
                BigInteger sub = num.remainder(BigInteger.TEN);
                num = num.divide(BigInteger.TEN).subtract(sub);
                sb.append(num).append("\n");
            }
            if (num.remainder(BigInteger.valueOf(11)).equals(BigInteger.ZERO)) {
                sb.append(String.format("The number %s is divisible by 11.\n\n", origin));
            } else {
                sb.append(String.format("The number %s is not divisible by 11.\n\n", origin));
            }
        }
        System.out.print(sb);
    }
}
