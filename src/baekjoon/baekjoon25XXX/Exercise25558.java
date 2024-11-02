package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise25558 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] start = new long[2];
        start[0] = Long.parseLong(st.nextToken());
        start[1] = Long.parseLong(st.nextToken());

        long[] end = new long[2];
        end[0] = Long.parseLong(st.nextToken());
        end[1] = Long.parseLong(st.nextToken());

        int oem = 0;
        long min = Long.MAX_VALUE;
        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            long totalDist = 0;

            long[][] pos = new long[n+2][2];
            pos[0] = start.clone();
            for (int j = 1; j <= n+1; j++) {
                if (j <= n) {
                    pos[j] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
                } else {
                    pos[j] = end.clone();
                }
                totalDist += Math.abs(pos[j][0]-pos[j-1][0]) + Math.abs(pos[j][1]-pos[j-1][1]);
            }

            if (min > totalDist) {
                min = totalDist;
                oem = i;
            }
        }
        System.out.println(oem);
    }
}
