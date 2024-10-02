package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10187 {
    private static final double GOLDEN = 1.61803399;
    private static final double DIFF = GOLDEN * 0.01;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            if (a/b >= GOLDEN-DIFF && a/b <= GOLDEN+DIFF) {
                System.out.println("golden");
            } else {
                System.out.println("not");
            }
        }
    }
}
