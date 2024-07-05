package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise12179 {

    private static final int LIMIT = 9000;
    private static final Map<Integer, BigInteger> cache = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            int d = Integer.parseInt(br.readLine());
            sb.append(String.format("Case #%d: %s\n", t, getOutput(d)));
        }
        br.close();
        System.out.print(sb);
    }

    private static String getOutput(int D) {
        for (int e = 1; e <= LIMIT; e++) {
            BigInteger nextResult = multifactorial(e);
            if (nextResult.toString().length() < D) {
                return "IT'S OVER 9000" + "!".repeat(e);
            }
        }
        return "...";
    }

    private static BigInteger multifactorial(int e) {
        if (cache.containsKey(e)) {
            return cache.get(e);
        }
        BigInteger product = IntStream.iterate(0, k -> k < LIMIT, k -> k+e)
                .mapToObj(k -> BigInteger.valueOf(LIMIT-k))
                .parallel()
                .reduce(BigInteger.ONE, BigInteger::multiply);
        cache.put(e, product);
        return product;
    }
}
