package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise28281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long[] price = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        br.close();

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            long sum = (price[i]+price[i+1])*x;
            minCost = Math.min(sum, minCost);
        }
        System.out.println(minCost);
    }
}
