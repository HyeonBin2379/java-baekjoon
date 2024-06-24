package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise6361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            String input = st.nextToken();

            sb.append(String.format("%d %s\n", before, input));
            BigInteger decimal = convertToDecimal(input, before);
            sb.append(String.format("%d %s\n\n", after, convertToBase(decimal, after)));
        }
        System.out.print(sb);
    }

    private static final String radix = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static BigInteger convertToDecimal(String input, int base) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger power = BigInteger.ONE;

        for (int i = input.length()-1; i >= 0; i--) {
            char curr = input.charAt(i);
            int digit = radix.indexOf(curr);
            decimal = decimal.add(power.multiply(BigInteger.valueOf(digit)));
            power = power.multiply(BigInteger.valueOf(base));
        }
        return decimal;
    }
    private static String convertToBase(BigInteger decimal, int base) {
        StringBuilder sb = new StringBuilder();

        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            int index = decimal.remainder(BigInteger.valueOf(base)).intValue();
            sb.append(radix.charAt(index));
            decimal = decimal.divide(BigInteger.valueOf(base));
        }
        return sb.isEmpty() ? "0" : sb.reverse().toString();
    }
}
