package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25024 {
    private static final int[] year = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append((x > 23 || y > 59) ? "No " : "Yes ");
            if (x >= 13 || x == 0 || y > 31 || y == 0) {
                sb.append("No").append("\n");
            } else {
                sb.append(y <= year[x] ? "Yes" : "No").append("\n");
            }
        }
        System.out.print(sb);
    }
}
