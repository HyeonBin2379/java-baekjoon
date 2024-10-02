package baekjoon.baekjoon08XXX;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Exercise8582 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = read();
        int[] arr = new int[n];
        int[][] cache = new int[n][2];

        cache[0][0] = arr[0] = read();
        for (int i = 1; i < n; i++) {
            cache[i][0] = Math.max(cache[i - 1][0], arr[i] = read());
        }

        cache[n-1][1] = arr[n-1];
        IntStream.iterate(n-2, i -> i >= 0, i -> i-1).forEach(i -> cache[i][1] = Math.max(cache[i + 1][1], arr[i]));
        for (int[] pair : cache) {
            bw.write(String.format("%d %d\n", pair[0], pair[1]));
        }
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
