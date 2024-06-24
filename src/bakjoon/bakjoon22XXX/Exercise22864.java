package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int work = 0;
        int f = 0;
        for (int i = 1; i <= 24; i++) {
            if (f + a <= m) {
                work += b;
                f += a;
            } else {
                f = Math.max(f-c, 0);
            }
        }
        System.out.println(work);
    }
}
