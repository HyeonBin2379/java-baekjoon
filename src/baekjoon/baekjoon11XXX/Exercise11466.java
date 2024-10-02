package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double h = Math.max(len[0], len[1]);
        double w = Math.min(len[0], len[1]);
        if (h >= w*3) {
            System.out.printf("%.3f", w);
        } else if (h >= w*1.5) {
            System.out.printf("%.3f", h/3);
        } else {
            System.out.printf("%.3f", w/2);
        }
    }
}
