package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31534 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min == max) {
            System.out.println(-1);
            return;
        }
        double z = (double)(min*h)/(max-min);
        double s1 = (Math.pow(z,2)+Math.pow(min, 2))*Math.PI;
        double s2 = (Math.pow(z+h, 2)+Math.pow(max, 2))*Math.PI;
        System.out.printf("%.7f\n", s2-s1);
    }
}
