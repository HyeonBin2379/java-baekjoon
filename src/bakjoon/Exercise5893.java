package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise5893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int[] binary = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int len = binary.length - 1;

        BigInteger num = BigInteger.ZERO;
        for (int i = len; i >= 0; i--) {
            if (binary[i] == 0) {
                continue;
            }
            num = num.add(BigInteger.TWO.pow(len-i));
        }
        num = num.multiply(BigInteger.valueOf(17));

        while (num.compareTo(BigInteger.ZERO) > 0) {
            if (num.remainder(BigInteger.TWO).equals(BigInteger.ONE)) {
                result.append("1");
            } else {
                result.append("0");
            }
            num = num.divide(BigInteger.TWO);
        }
        String answer = result.reverse().toString();
        System.out.println(answer.substring(answer.indexOf("1")));
    }
}
