package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16088 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            if (n == m) {
                sb.append("G").append("\n");
                continue;
            }

            String answer = "";
            int countWay = 0;
            if (Math.abs(n-m) <= l) {
                answer = "L";
                countWay++;
            }
            if (Math.abs(n-m) <= r) {
                answer = "R";
                countWay++;
            }
            if (countWay > 1) {
                answer = "E";
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
