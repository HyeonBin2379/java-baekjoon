package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise31324 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger total = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            total = total.multiply(BigInteger.valueOf(2L*i));
        }
        if (total.compareTo(m) >= 0) {
            System.out.println("Harshat Mata");
        } else {
            System.out.println("Nope");
        }
    }
}
