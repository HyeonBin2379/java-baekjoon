package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int point = Integer.parseInt(br.readLine());
        long[][] pos = new long[point+1][2];
        for (int i = 0; i < point; i++) {
            pos[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        pos[point] = pos[0];
        br.close();

        long result = 0;
        for (int i = 0; i < point; i++) {
            result += (pos[i][0]*pos[i+1][1])-(pos[i+1][0]*pos[i][1]);
        }
        System.out.printf("%.1f\n", Math.abs(result / 2.0));
    }
}
