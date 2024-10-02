package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17387 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] line1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] line2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(isCross(line1, line2) ? 1 : 0);
    }

    private static int ccw(long[] line, long[] point) {
        long temp =  (line[0]*line[3] + line[2]*point[1] + point[0]*line[1])
                - (line[2]*line[1] + point[0]*line[3] + line[0]*point[1]);
        return Long.compare(temp, 0);
    }

    private static boolean isCross(long[] line1, long[] line2) {
        int abc = ccw(line1, new long[] {line2[0], line2[1]});
        int abd = ccw(line1, new long[] {line2[2], line2[3]});
        int cda = ccw(line2, new long[] {line1[0], line1[1]});
        int cdb = ccw(line2, new long[] {line1[2], line1[3]});

        if (abc*abd == 0 && cda*cdb == 0) {
            return isOverlab(line1, line2);
        } else
            return abc * abd <= 0 && cda * cdb <= 0;
    }

    private static boolean isOverlab(long[] line1, long[] line2) {
        return Math.min(line1[0], line1[2]) <= Math.max(line2[0], line2[2])
                && Math.min(line2[0], line2[2]) <= Math.max(line1[0], line1[2])
                && Math.min(line1[1], line1[3]) <= Math.max(line2[1], line2[3])
                && Math.min(line2[1], line2[3]) <= Math.max(line1[1], line1[3]);
    }
}
