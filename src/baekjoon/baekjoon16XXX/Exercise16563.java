package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise16563 {

    private static final int[] prime = setPrimeNum();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            while (num > 1) {
                sb.append(prime[num]).append(" ");
                num /= prime[num];
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[] setPrimeNum() {
        int[] result = new int[5000001];
        IntStream.range(2, 5000000).forEach(idx -> result[idx] = idx);
        for (int i = 2; i*i <= 5000000; i++) {
            for (int j = i*i; j <= 5000000; j += i) {
                if (result[j] == j) {
                    result[j] = i;
                }
            }
        }
        return result;
    }
}
