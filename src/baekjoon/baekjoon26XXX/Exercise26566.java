package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] data1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] data2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double slice = (double) data1[0] / data1[1];
            double whole = Math.PI * Math.pow(data2[0], 2) / data2[1];
            sb.append((slice < whole) ? "Whole pizza" : "Slice of pizza").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
