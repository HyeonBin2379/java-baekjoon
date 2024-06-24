package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < n; j++) {
                BigInteger input = new BigInteger(br.readLine());
                sum = sum.add(input);
            }

            if (sum.compareTo(BigInteger.ZERO) < 0) {
                sb.append("-\n");
            } else if (sum.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0\n");
            } else {
                sb.append("+\n");
            }
        }
        System.out.print(sb);
    }
}
