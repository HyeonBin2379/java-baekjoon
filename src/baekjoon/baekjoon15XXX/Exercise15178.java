package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] angle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(angle).sum();
            for (int j = 0; j < 3; j++) {
                sb.append(angle[j]).append(" ");
            }
            sb.append((sum == 180) ? "Seems OK\n" : "Check\n");
        }
        System.out.print(sb);
    }
}
