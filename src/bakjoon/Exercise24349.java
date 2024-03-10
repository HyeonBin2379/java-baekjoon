package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24349 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int dist = 0;
        int now = 0;
        for (int i = 0; i < n-1; i++) {
            switch (now) {
                case 0 -> {
                    dist += Math.min(a, b);
                    now = (a < b) ? 1 : 2;
                }
                case 1 -> {
                    dist += Math.min(a, c);
                    now = (a < c) ? 0 : 2;
                }
                case 2 -> {
                    dist += Math.min(b, c);
                    now = (b < c) ? 0 : 1;
                }
            }
        }
        System.out.println((dist/100) + " " + (dist%100));
    }
}
