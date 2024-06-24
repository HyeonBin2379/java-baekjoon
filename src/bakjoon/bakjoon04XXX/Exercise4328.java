package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise4328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int b = Integer.parseInt(st.nextToken());
            BigInteger p = new BigInteger(st.nextToken(), b);
            BigInteger m = new BigInteger(st.nextToken(), b);
            System.out.println(p.remainder(m).toString(b));
        }
    }
}
