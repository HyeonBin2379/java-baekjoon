package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11340 {

    private static final double[] percentage = {0.15, 0.20, 0.25};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double[] score = new double[3];
            double total = 0.0;
            for (int j = 0; j < 3; j++) {
                score[j] = Integer.parseInt(st.nextToken()) * percentage[j];
                total += score[j];
            }

            int answer = -1;
            for (int j = 0; j <= 100; j++) {
                double exam = 0.4*j;
                if (Double.compare(total + exam, 90.0) >= 0) {
                    answer = j;
                    break;
                }
            }
            System.out.println(answer < 0 ? "impossible" : answer);
        }
    }
}
