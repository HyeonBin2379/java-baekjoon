package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long a1 = Long.parseLong(st.nextToken());
        long a2 = Long.parseLong(st.nextToken());

        System.out.printf("%.6f\n", (b + Math.sqrt(b*b + 4*c))/2.0);
    }
}
