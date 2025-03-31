package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] factors = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        System.out.println(factors[0]*factors[n-1]);
    }
}
