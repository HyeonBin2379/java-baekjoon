package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] difficulty = new int[n];
        for (int i = 0; i < n; i++) {
            difficulty[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(difficulty);

        int cut = (int)Math.round(n*0.15);
        int sum = IntStream.range(0, n).filter(idx -> cut <= idx && idx < n-cut).map(idx -> difficulty[idx]).sum();
        System.out.println((int)Math.round((double)sum/(n-2*cut)));
    }
}
