package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bulb = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1 -> bulb[b] = c;
                case 2 -> {
                    for (int j = b; j <= c; j++) {
                        bulb[j] = (bulb[j] == 1) ? 0 : 1;
                    }
                }
                case 3 -> {
                    for (int j = b; j <= c; j++) {
                        bulb[j] = 0;
                    }
                }
                case 4 -> {
                    for (int j = b; j <= c; j++) {
                        bulb[j] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(bulb[i] + " ");
        }
    }
}
