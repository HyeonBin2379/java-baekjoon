package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String before = br.readLine();
            String after = br.readLine();

            int w = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if (before.charAt(i) == after.charAt(i)) {
                    continue;
                }
                if (before.charAt(i) == 'B') {
                    b++;
                } else {
                    w++;
                }
            }
            System.out.println(Math.max(w, b));
        }
    }
}
