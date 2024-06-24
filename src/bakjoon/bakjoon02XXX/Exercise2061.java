package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise2061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        BigInteger l = new BigInteger(st.nextToken());

        for (int i = 2; i < l.intValue(); i++) {
            if (k.remainder(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                System.out.println("BAD " + i);
                return;
            }
        }
        System.out.println("GOOD");
    }
}
