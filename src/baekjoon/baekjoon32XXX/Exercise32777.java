package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32777 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int diff = Math.abs(a-b);

            if (diff < 43-diff) {
                System.out.println(a < b ? "Inner circle line" : "Outer circle line");
            } else if (diff > 43-diff) {
                System.out.println(a < b ? "Outer circle line" : "Inner circle line");
            } else {
                System.out.println("Same");
            }
        }
    }
}
