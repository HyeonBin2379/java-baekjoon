package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17386 {
    private static final long[][] lines = new long[2][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < lines.length; i++) {
            lines[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        br.close();

        System.out.println(isCross(lines) ? 1 : 0);
    }

    public static boolean isCross(long[][] lines) {
        int abc = ccw(lines[0], lines[1][0], lines[1][1]);
        int abd = ccw(lines[0], lines[1][2], lines[1][3]);
        int cda = ccw(lines[1], lines[0][0], lines[0][1]);
        int cdb = ccw(lines[1], lines[0][2], lines[0][3]);
        if (abc * abd == 0 && cda * cdb == 0) {
            return isOverlab(lines);
        } else {
            return abc * abd <= 0 && cda * cdb <= 0;
        }
    }

    public static int ccw(long[] line, long x, long y) {
        long result = (line[0]*line[3] + line[2]*y + x*line[1])
                - (line[2]*line[1] + x*line[3] + line[0]*y);
        return Long.compare(result, 0L);
    }

    public static boolean isOverlab(long[][] lines) {
        return isXOverlab(lines) && isYOverlab(lines);
    }
    private static boolean isXOverlab(long[][] lines) {
        return Math.min(lines[0][0], lines[0][2]) <= Math.max(lines[1][0], lines[1][2])
                && Math.min(lines[1][0], lines[1][2]) <= Math.max(lines[0][0], lines[0][2]);
    }
    private static boolean isYOverlab(long[][] lines) {
        return Math.min(lines[0][1], lines[0][3]) <= Math.max(lines[1][1], lines[1][3])
                && Math.min(lines[1][1], lines[1][3]) <= Math.max(lines[0][1], lines[0][3]);
    }
}
