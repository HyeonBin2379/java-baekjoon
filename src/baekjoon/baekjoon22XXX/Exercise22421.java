package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            double min = Double.MAX_VALUE;
            for (int i = 0; i <= d; i++) {
                for (int j = 0; j <= d; j++) {
                    if (i+j == d) {
                        double cost = Math.abs(Math.sqrt(i*i + j*j) - e);
                        min = Math.min(min, cost);
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }
}
