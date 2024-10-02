package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20410 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        for (int a = 0; a < m; a++) {
            for (int c = 0; c < m; c++) {
                int res1 = (a*seed+c) % m;
                int res2 = (a*x1+c) % m;
                if (res1 == x1 && res2 == x2) {
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }
    }
}
