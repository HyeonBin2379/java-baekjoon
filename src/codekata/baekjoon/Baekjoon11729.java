package codekata.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11729 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        sb.append((long)(Math.pow(2, k)-1)).append("\n");
        hanoiTop(k, 1, 3);
        System.out.println(sb);
    }

    private static void hanoiTop(int n, int from, int to) {
        if (n == 1) {
            sb.append(String.format("%d %d%n", from, to));
            return;
        }
        hanoiTop(n - 1, from, 6 - from - to);
        sb.append(String.format("%d %d%n", from, to));
        hanoiTop(n - 1, 6 - from - to, to);
    }
}
