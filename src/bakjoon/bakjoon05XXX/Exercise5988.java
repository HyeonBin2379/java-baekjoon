package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise5988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            BigInteger num = new BigInteger(br.readLine());
            if (num.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
                sb.append("even\n");
            } else {
                sb.append("odd\n");
            }
        }
        System.out.print(sb);
    }
}
