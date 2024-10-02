package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise31738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if (n > m) {
            System.out.println(factorial(1, m, m));
        } else {
            System.out.println(factorial(1, n, m));
        }
    }

    public static BigInteger factorial(long start, long end, long m) {
        BigInteger result = BigInteger.valueOf(start);
        if (start < end) {
            long mid = (start + end) / 2;
            BigInteger left = factorial(start, mid, m).remainder(BigInteger.valueOf(m));
            BigInteger right = factorial(mid+1, end, m).remainder(BigInteger.valueOf(m));
            result = left.multiply(right);
        }
        return result.remainder(BigInteger.valueOf(m));
    }
}
