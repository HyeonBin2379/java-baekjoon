package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] expectedRank = new long[n];
        for (int i = 0; i < n; i++) {
            expectedRank[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(expectedRank);

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (expectedRank[i] != i+1) {
                cnt += Math.abs(i+1 - expectedRank[i]);
            }
        }
        System.out.println(cnt);
    }
}
