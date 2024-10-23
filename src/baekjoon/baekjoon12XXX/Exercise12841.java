package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12841 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] crossWalk = getCrosswalk(n);
        long[] left = getSide(n);
        long[] right = getSide(n);

        long answer = Long.MAX_VALUE;
        int crossWalkNumber = n+1;
        for (int i = 1; i <= n; i++) {
            long total = left[i] + crossWalk[i] + (right[n]-right[i]);
            if (total < answer) {
                answer = total;
                crossWalkNumber = i;
            }
        }
        System.out.println(crossWalkNumber + " " + answer);
    }

    private static long[] getCrosswalk(int end) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[end+1];
        for (int i = 1; i <= end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    private static long[] getSide(int end) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[end+1];
        for (int i = 2; i <= end; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
