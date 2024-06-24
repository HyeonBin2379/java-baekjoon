package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise1740 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] binary = Arrays.stream(Long.toBinaryString(n).split("")).mapToInt(Integer::parseInt).toArray();
        int len = binary.length;

        BigInteger answer = BigInteger.ZERO;
        for (int i = len-1; i >= 0; i--) {
            if (binary[i] == 1) {
                answer = answer.add(BigInteger.valueOf(3).pow(len-1-i));
            }
        }
        System.out.println(answer);
    }
}
