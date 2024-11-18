package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32642 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] weather = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] rage = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                rage[i] += (weather[i] == 0) ? -1 : 1;
            } else {
                rage[i] = (weather[i] == 0) ? rage[i-1]-1 : rage[i-1]+1;
            }
        }
        System.out.println(Arrays.stream(rage).sum());
    }
}
