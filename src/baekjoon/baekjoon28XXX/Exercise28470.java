package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] attack = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] evasion = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        double[] k = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        long answer = 0;
        for (int i = 0; i < n; i++) {
            long attackFirst = (long) (attack[i]*(k[i] * 10)) / 10;
            long evadeFirst = (long) (evasion[i]*(k[i] * 10)) / 10;
            answer += (k[i] >= 1) ? attackFirst - evasion[i] : attack[i] - evadeFirst;
        }
        System.out.println(answer);
    }
}