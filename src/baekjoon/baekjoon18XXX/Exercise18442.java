package baekjoon.baekjoon18XXX;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise18442 {
    private static int v, p;
    private static long l, minDist;
    private static long[] village, selected, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        l = Long.parseLong(st.nextToken());
        village = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        minDist = Long.MAX_VALUE;
        selected = new long[p];
        backtrack(0, 0);

        System.out.println(minDist);
        System.out.println(Arrays.stream(answer).mapToObj(Long::toString).collect(Collectors.joining(" ")));
    }

    private static void backtrack(int start, int count) {
        if (count == p) {
            long totalDist = calculateTotalDist();
            if (totalDist < minDist) {
                minDist = totalDist;
                answer = selected.clone();
            }
            return;
        }
        for (int i = start; i < v; i++) {
            selected[count] = village[i];
            backtrack(i + 1, count+1);
            selected[count] = 0;
        }
    }

    private static long calculateTotalDist() {
        long totalDist = 0;
        for (long v : village) {
            long minDistance = Long.MAX_VALUE;
            for (long p : selected) {
                long diff = Math.min(Math.abs(v - p), l - Math.abs(v-p));
                minDistance = Math.min(minDistance, diff);
            }
            totalDist += minDistance;
        }
        return totalDist;
    }
}
