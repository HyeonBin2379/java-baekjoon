package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) {
                break;
            }
            sb.append(String.format("Case %d:", ++testCase));
            long a = 0, b = 0;
            long M = 0;
            for (int i = 0; i < num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                long m = Long.parseLong(st.nextToken());
                a += x*m;
                b += y*m;
                M += m;
            }
            sb.append(String.format(" %.2f %.2f\n", (double)a/M, (double)b/M));
            br.readLine();
        }
        System.out.print(sb);
    }
}
