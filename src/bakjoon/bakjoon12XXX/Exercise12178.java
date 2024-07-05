package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise12178 {

    private static final int LIMIT = 9000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            int d = Integer.parseInt(br.readLine());
            sb.append(String.format("Case #%d: %s\n", t, getOutput(d)));
        }
        br.close();
        System.out.print(sb);
    }

    private static String getOutput(int D) {
        for (int e = 1; e <= LIMIT; e++) {
            BigInteger nextResult = multifactorial(e);
            if (nextResult.toString().length() < D) {
                return "IT'S OVER 9000" + "!".repeat(e);
            }
        }
        return "...";
    }

    private static BigInteger multifactorial(int e) {
        BigInteger product = BigInteger.ONE;
        for (int k = 0; LIMIT - k > 0; k += e) {
            product = product.multiply(BigInteger.valueOf(LIMIT - k));
        }
        return product;
    }
}
