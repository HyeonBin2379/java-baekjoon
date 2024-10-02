package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise1914 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int moveCount = Integer.parseInt(br.readLine());
        BigInteger totalCount = BigInteger.TWO.pow(moveCount).subtract(BigInteger.ONE);
        sb.append(totalCount).append("\n");
        if (moveCount <= 20) {
            hanoi(moveCount, 1, 3, 2);
        }
        System.out.println(sb);
    }

    public static void hanoi(int moveCount, int from, int to, int by) {
        if (moveCount == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(moveCount - 1, from, by, to);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(moveCount - 1, by, to, from);
        }
    }
}