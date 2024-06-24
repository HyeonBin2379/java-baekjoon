package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise6378 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            BigInteger input = new BigInteger(br.readLine());
            if (input.equals(BigInteger.ZERO)) {
                break;
            }

            while (input.compareTo(BigInteger.TEN) >= 0) {
                int[] num = Arrays.stream(input.toString().split("")).mapToInt(Integer::parseInt).toArray();
                int sum = Arrays.stream(num).sum();
                input = BigInteger.valueOf(sum);
            }
            sb.append(input).append("\n");
        }
        System.out.print(sb);
    }
}
