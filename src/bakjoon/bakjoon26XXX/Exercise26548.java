package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26548 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            double d = Math.sqrt(b*b - 4*a*c);
            double max = (-b + d)/(2*a);
            double min = (-b - d)/(2*a);
            System.out.printf("%.3f, %.3f\n", max, min);
        }
    }
}
