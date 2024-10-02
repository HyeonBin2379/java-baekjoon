package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1894 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double[][] dots = new double[4][2];
            for (int i = 0; i < 4; i++) {
                dots[i][0] = Double.parseDouble(st.nextToken());
                dots[i][1] = Double.parseDouble(st.nextToken());
            }

            // 나머지 한 점 구하기
            double[] answer = new double[2];
            if (dots[0][0] == dots[2][0] && dots[0][1] == dots[2][1]) {
                answer[0] = dots[1][0] + dots[3][0] - dots[0][0];
                answer[1] = dots[1][1] + dots[3][1] - dots[0][1];
            }
            if (dots[0][0] == dots[3][0] && dots[0][1] == dots[3][1]) {
                answer[0] = dots[1][0] + dots[2][0] - dots[0][0];
                answer[1] = dots[1][1] + dots[2][1] - dots[0][1];
            }
            if (dots[1][0] == dots[2][0] && dots[1][1] == dots[2][1]) {
                answer[0] = dots[0][0] + dots[3][0] - dots[1][0];
                answer[1] = dots[0][1] + dots[3][1] - dots[1][1];
            }
            if (dots[1][0] == dots[3][0] && dots[1][1] == dots[3][1]) {
                answer[0] = dots[0][0] + dots[2][0] - dots[1][0];
                answer[1] = dots[0][1] + dots[2][1] - dots[1][1];
            }
            sb.append(String.format("%.3f %.3f\n", answer[0], answer[1]));
        }
        System.out.print(sb);
    }
}
