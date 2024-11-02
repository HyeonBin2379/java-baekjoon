package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise25576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] viewers = new int[n][m];
        for (int i = 0; i < n; i++) {
            viewers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int[] viewer : viewers) {
            int diff = IntStream.range(0, m).map(idx -> Math.abs(viewers[0][idx] - viewer[idx])).sum();
            if (diff > 2000) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
