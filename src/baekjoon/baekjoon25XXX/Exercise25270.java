package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25270 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int minDiff = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= 10000; i++) {
            if (i % 100 == 99) {
                int diff = Math.abs(i - num);
                if (diff < minDiff) {
                    minDiff = diff;
                    answer = i;
                } else if (diff == minDiff) {
                    answer = Math.max(i, answer);
                }
            }
        }
        System.out.println(answer);
    }
}
