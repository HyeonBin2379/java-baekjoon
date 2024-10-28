package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise24927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        BigInteger pow = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (num % 2 == 0) {
                pow = pow.multiply(BigInteger.TWO);
                num /= 2;
            }
        }

        if (pow.compareTo(BigInteger.TWO.pow(k)) >= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
