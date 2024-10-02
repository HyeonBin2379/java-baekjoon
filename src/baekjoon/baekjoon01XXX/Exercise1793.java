package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise1793 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger[] dp = new BigInteger[251];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = (i < 2) ? BigInteger.ONE : dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
        }

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(dp[n].toString()).append("\n");
        }
        System.out.print(sb);
    }
}
