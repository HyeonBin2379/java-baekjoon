package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise9313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            String binary = new StringBuilder(String.format("%032d", new BigInteger(Integer.toBinaryString(n))))
                    .reverse()
                    .toString();
            System.out.println(new BigInteger(binary, 2));
        }
    }
}
