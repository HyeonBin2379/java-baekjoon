package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] sticks = new long[n];
        long total = 0L;
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
            total += sticks[i];
        }
        Arrays.sort(sticks);

        long answer = 0L;
        for (int i = 0; i < n; i++) {
            answer += sticks[i]*(total-sticks[i]);
            total -= sticks[i];
        }
        System.out.println(answer);
    }
}
