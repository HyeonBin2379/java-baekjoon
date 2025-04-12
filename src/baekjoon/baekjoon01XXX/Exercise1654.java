package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lines = new long[k];
        long start = 1, end = 1;
        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
            end = Math.max(lines[i], end);
        }

        while (start <= end) {
            long mid = (start+end)/2;
            long count = Arrays.stream(lines).map(line -> line/mid).sum();

            if (count >= n) {   // 합이 n 이상이 되는 이분탐색
                start = mid+1;
            } else {            // 합이 n 미만이 되는 이분탐색
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
