package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise4070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) {
                break;
            }
            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                name[i] = br.readLine();
            }
            Arrays.sort(name, Comparator.comparingInt(String::length));
            sb.append(String.format("Case %d: ", ++caseNum));
            sb.append(canMakeTeam(name, n, k) ? "yes\n\n" : "no\n\n");
        }
        System.out.print(sb);
    }

    private static boolean canMakeTeam(String[] name, int n, int k) {
        return IntStream.iterate(0, i -> i < n, i -> i+k).allMatch(i -> isValidTeam(name, i, i+k));
    }

    private static boolean isValidTeam(String[] name, int start, int end) {
        int totalLength = IntStream.rangeClosed(start, end-1).map(i -> name[i].length()).sum();
        double avg = (double) totalLength / (end-start);
        return IntStream.rangeClosed(start, end-1)
                .map(i -> name[i].length())
                .allMatch(len -> Math.abs(len - avg) <= 2);
    }
}
