package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long testCase = 1;
        while (true) {
            long[] days = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (isAllZero(days)) {
                break;
            }

            long result = (days[2] / days[1])*days[0] + Math.min(days[2] % days[1], days[0]);
            bw.write(String.format("Case %d: %d\n", testCase++, result));
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isAllZero(long[] arr) {
        return Arrays.stream(arr)
                .allMatch(value -> value == 0);
    }
}
