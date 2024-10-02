package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise11665 {

    private static class Range {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Range[] xyz = IntStream.range(0, 3).mapToObj(i -> new Range(0, 1001)).toArray(Range[]::new);

        for (int i = 1; i <= count; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 3; j++) {
                xyz[j].start = Math.max(pos[j], xyz[j].start);
                xyz[j].end = Math.min(pos[j+3], xyz[j].end);
            }
        }

        int[] len = IntStream.range(0, 3)
                .map(i -> Math.max(0, xyz[i].end-xyz[i].start))
                .toArray();
        System.out.println(len[0]*len[1]*len[2]);
    }
}
