package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] input = Arrays.stream(br.readLine().split(""))
                    .distinct()
                    .collect(Collectors.joining())
                    .toCharArray();
            int sum = 2015;
            for (char c : input) {
                sum -= c;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}