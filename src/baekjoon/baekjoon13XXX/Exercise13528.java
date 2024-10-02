package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13528 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double c = Double.parseDouble(br.readLine().trim());
        int count = Integer.parseInt(br.readLine().trim());
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double w = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());
            total += w*h;
        }
        System.out.printf("%.6f\n", total*c);
    }
}
