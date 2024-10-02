package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise25858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] solved = new int[n];
        for (int i = 0; i < n; i++) {
            solved[i] = Integer.parseInt(br.readLine());
        }

        int reward = d / Arrays.stream(solved).sum();
        Arrays.stream(solved).map(operand -> operand * reward).forEach(System.out::println);
    }
}
