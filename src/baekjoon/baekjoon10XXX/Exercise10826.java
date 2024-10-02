package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise10826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        BigInteger[] seq = new BigInteger[num+1];
        Arrays.fill(seq, BigInteger.ZERO);
        for (int i = 1; i <= num; i++) {
            seq[i] = (i > 1) ? seq[i-1].add(seq[i-2]) : BigInteger.ONE;
        }
        System.out.println(seq[num]);
    }
}
