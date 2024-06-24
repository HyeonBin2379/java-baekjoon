package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9297 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sb.append(String.format("Case %d:", i));
            if (n == 0) {
                sb.append(" 0\n");
                continue;
            }

            if (n/d > 0) {
                sb.append(String.format(" %d", n/d));
            }
            if (n % d > 0) {
                sb.append(String.format(" %d/%d", n % d, d));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
