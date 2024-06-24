package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise6571 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger[] fib = new BigInteger[1000];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = (i < 3) ? BigInteger.valueOf(i) : fib[i-2].add(fib[i-1]);
        }

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            int count = 0;
            for (int i = 1; i < fib.length; i++) {
                if (fib[i].compareTo(a) >= 0 && fib[i].compareTo(b) <= 0) {
                    count++;
                } else if (fib[i].compareTo(b) > 0) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
