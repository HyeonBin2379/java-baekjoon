package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            double d = Double.parseDouble(st.nextToken());
            int rw = Integer.parseInt(st.nextToken());
            int rh = Integer.parseInt(st.nextToken());

            double w = d*16/Math.sqrt(337);
            double h = w*9/16;
            sb.append(String.format("Horizontal DPI: %.2f\nVertical DPI: %.2f\n", rw/w, rh/h));
        }
        System.out.print(sb);
    }
}
