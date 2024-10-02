package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double price = Double.parseDouble(st.nextToken());
        int gram = Integer.parseInt(st.nextToken());

        int testCase = Integer.parseInt(br.readLine());
        double[] perKg = new double[testCase+1];
        perKg[0] = price*1000/gram;
        for (int i = 1; i <= testCase; i++) {
            st = new StringTokenizer(br.readLine());
            double p = Double.parseDouble(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            perKg[i] = p*1000/g;
        }
        System.out.printf("%.2f\n", Arrays.stream(perKg).min().getAsDouble());
    }
}
