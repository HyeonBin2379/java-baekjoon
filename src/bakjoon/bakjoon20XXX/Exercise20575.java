package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            if (Math.floor(x1) != Math.floor(x2)) {
                count++;
            }
        }
        double answer = (double)count/n;
        System.out.printf("%.6f\n", 2/answer);
    }
}
