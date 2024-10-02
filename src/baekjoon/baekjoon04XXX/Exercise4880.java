package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4880 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
                break;
            }
            if (num[0]*num[2] == num[1]*num[1]) {
                sb.append(String.format("GP %d\n", num[2]*num[2] / num[1]));
            } else {
                sb.append(String.format("AP %d\n", num[2]*2 - num[1]));
            }
        }
        System.out.print(sb);
    }
}
