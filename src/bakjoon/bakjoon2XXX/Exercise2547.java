package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise2547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j < n; j++) {
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            sb.append((sum.remainder(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}
