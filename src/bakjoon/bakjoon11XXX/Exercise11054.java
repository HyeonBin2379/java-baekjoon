package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] asc = new int[n+1];
        for (int i = 1; i <= n; i++) {
            asc[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (seq[i] > seq[j]) {
                    asc[i] = Math.max(asc[j]+1, asc[i]);
                }
            }
        }
        int[] desc = new int[n+1];
        for (int i = n; i >= 1; i--) {
            desc[i] = 1;
            for (int j = n; j >= i; j--) {
                if (seq[i] > seq[j]) {
                    desc[i] = Math.max(desc[j]+1, desc[i]);
                }
            }
        }
        System.out.println(IntStream.rangeClosed(1, n).map(idx -> asc[idx]+desc[idx]-1).max().getAsInt());
    }
}