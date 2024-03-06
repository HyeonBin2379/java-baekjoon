package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        BigInteger[] seq = new BigInteger[num+1];

        Arrays.fill(seq, BigInteger.ONE);
        for (int i = 2; i <= num; i++) {
            seq[i] = seq[i-1].add(seq[i-2]);
        }
        BigInteger len = seq[num].add(seq[num-1]).multiply(BigInteger.TWO);
        System.out.println(len);
    }
}
