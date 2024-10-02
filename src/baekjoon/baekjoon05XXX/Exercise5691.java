package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (num[0] == 0L && num[1] == 0L) {
                break;
            }
            sb.append(num[0]*3 - num[0] - num[1]).append("\n");
        }
        System.out.print(sb);
    }
}
