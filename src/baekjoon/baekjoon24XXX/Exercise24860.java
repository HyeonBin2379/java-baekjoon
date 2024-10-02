package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] data = new long[3][];
        data[0] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        data[1] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        data[2] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long total = 0;
        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                total += (data[i][0]*data[i][1]);
                continue;
            }
            for (int j = 0; j < 3; j++) {
                total *= data[i][j];
            }
        }
        System.out.println(total);
    }
}
