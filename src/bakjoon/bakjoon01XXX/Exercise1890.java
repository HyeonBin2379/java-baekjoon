package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[][] board = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).map(BigInteger::new).toArray(BigInteger[]::new);
        }

        BigInteger[][] dp = new BigInteger[n][n];
        IntStream.rangeClosed(0, n-1).forEach(i -> Arrays.fill(dp[i], BigInteger.ZERO));
        dp[0][0] = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BigInteger val = board[i][j];
                if (val.equals(BigInteger.ZERO) || dp[i][j].equals(BigInteger.ZERO)) {
                    continue;
                }
                if (i+val.intValue() < n) {
                    dp[i+val.intValue()][j] = dp[i+val.intValue()][j].add(dp[i][j]);
                }
                if (j+val.intValue() < n) {
                    dp[i][j+val.intValue()] = dp[i][j+val.intValue()].add(dp[i][j]);
                }
            }
        }
        System.out.println(dp[n-1][n-1].toString());
    }
}
