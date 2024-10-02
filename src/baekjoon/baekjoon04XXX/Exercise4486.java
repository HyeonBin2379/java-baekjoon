package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            sb.append(String.format("Case %d:\n", ++testCase));
            sb.append(String.format("%d pencils for %d cents\n", n, n));
            int count = 0;
            for (int a = 1; a <= n/4; a++) {
                for (int b = 1; b <= n; b++) {
                    for (int c = 1; c <= n; c++) {
                        if (4*a + 0.5*b + 0.25*c == (double)n && a+b+c == n) {
                            sb.append(String.format("%d at four cents each\n", a))
                                    .append(String.format("%d at two for a penny\n", b))
                                    .append(String.format("%d at four for a penny\n\n", c));
                            count++;
                        }
                    }
                }
            }
            if (count == 0) {
                sb.append("No solution found.\n\n");
            }
        }
        System.out.print(sb);
    }
}
