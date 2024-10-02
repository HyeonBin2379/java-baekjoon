package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25369 {

    private static int N;
    private static long targetProduct = 1;
    private static String best = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        targetProduct = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).reduce(1, (a, b) -> a*b);

        backtrack(new int[N], 0);
        System.out.println(best.isEmpty() ? -1 : best);
    }

    private static void backtrack(int[] B, int depth) {
        if (depth == N) {
            long product = calculateProduct(B);
            if (product > targetProduct) {
                String currentB = buildString(B);
                if (best.isEmpty() || currentB.compareTo(best) < 0) {
                    best = currentB;
                }
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            B[depth] = i;
            backtrack(B, depth + 1);
        }
    }

    private static long calculateProduct(int[] array) {
        return Arrays.stream(array).mapToLong(i -> i).reduce(1, (a, b) -> a*b);
    }

    private static String buildString(int[] B) {
        StringBuilder sb = new StringBuilder();
        for (int j : B) {
            sb.append(j).append(" ");
        }
        return sb.toString().trim();
    }
}
