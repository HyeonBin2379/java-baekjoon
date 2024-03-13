package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise9711 {
    private static final List<BigInteger> fib = new ArrayList<>(List.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        getFibonacci();
        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            sb.append(String.format("Case #%d: ", i)).append(fib.get(p).remainder(BigInteger.valueOf(q))).append("\n");
        }
        System.out.print(sb);
    }

    public static void getFibonacci() {
        while (fib.size() <= 10000) {
            BigInteger newNum = fib.get(fib.size()-2).add(fib.get(fib.size()-1));
            fib.add(newNum);
        }
    }
}
