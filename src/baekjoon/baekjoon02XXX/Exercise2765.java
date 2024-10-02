package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2765 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double d = Double.parseDouble(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            double t = Double.parseDouble(st.nextToken());

            if (r == 0) {
                break;
            }
            d = (3.1415927*d*r)/63360;
            t /= 3600;
            sb.append(String.format("Trip #%d: %.2f %.2f\n", ++count, d, d/t));
        }
        System.out.print(sb);
    }
}
