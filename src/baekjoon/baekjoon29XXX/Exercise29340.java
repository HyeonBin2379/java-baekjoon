package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num1 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < num1.length; i++) {
            sb.append(Math.max(num1[i], num2[i]));
        }
        System.out.println(sb);
    }
}
