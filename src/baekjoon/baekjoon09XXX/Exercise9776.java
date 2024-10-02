package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        double max = 0d;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            double r = Double.parseDouble(st.nextToken());
            double result = switch (type) {
                case "C" -> Math.PI * Math.pow(r, 2) * Double.parseDouble(st.nextToken()) / 3;
                case "L" -> Math.PI * Math.pow(r, 2) * Double.parseDouble(st.nextToken());
                case "S" -> 4 * Math.PI * Math.pow(r, 3) / 3;
                default -> 0d;
            };
            max = Math.max(result, max);
        }
        System.out.printf("%.3f\n", max);
    }
}
