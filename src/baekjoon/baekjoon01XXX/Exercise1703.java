package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            int[] lenAndLeaves = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int len = lenAndLeaves[0]*2;
            int leaf = 1;
            for (int i = 1; i < len; i += 2) {
                leaf *= lenAndLeaves[i];
                leaf -= lenAndLeaves[i+1];
            }
            sb.append(leaf).append("\n");
        }
        System.out.print(sb);
    }
}
