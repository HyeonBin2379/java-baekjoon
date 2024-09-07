package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (Arrays.stream(num).allMatch(value -> value == -1)) {
                break;
            }

            long tournament = num[0]*num[2] + num[3];
            long group = (num[1]*(num[1]-1)/2)*num[0];
            for (long i = 1; i < tournament; i++) {
                long pow = (long)Math.pow(2, i);
                if ((long)Math.pow(2, i) >= tournament) {
                    tournament = Math.max(pow, tournament);
                    break;
                }
            }
            long x = group + (tournament-1);
            long y = (num[3] > 0) ? tournament-(num[0]*num[2]+num[3]) : 0;

            System.out.printf("%d*%d/%d+%d=%d+%d\n", num[0], num[2], num[1], num[3], x, y);
        }
    }
}
