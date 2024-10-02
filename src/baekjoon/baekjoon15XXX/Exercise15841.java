package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Exercise15841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger[] infected = new BigInteger[491];
        Arrays.fill(infected, BigInteger.ZERO);
        infected[1] = BigInteger.ONE;
        for (int i = 2; i < infected.length; i++) {
            infected[i] = infected[i-1].add(infected[i-2]);
        }

        while (true) {
            int hour = Integer.parseInt(br.readLine());
            if (hour == -1) {
                break;
            }
            sb.append(String.format("Hour %d: %s cow(s) affected\n", hour, infected[hour]));
        }
        System.out.print(sb);
    }
}
