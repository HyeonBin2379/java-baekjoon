package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] P = new int[n];
        int[] M = new int[n];
        Arrays.fill(P, -1);
        Arrays.fill(M, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            String function = st.nextToken();
            if (function.equals("P")) {
                P[num] = Integer.parseInt(st.nextToken());
            } else {
                M[num] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 0, max = n;
        for (int i = 0; i < n; i++) {
            if (P[i] == 1 && M[i] == 0) {
                min++;
            } else if (P[i] == 0 || M[i] == 1) {
                max--;
            }
        }
        System.out.println(min + " " + max);
    }
}
