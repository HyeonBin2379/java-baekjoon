package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int test = Integer.parseInt(st.nextToken());
            double[] data = new double[4];
            for (int j = 0; j < 4; j++) {
                data[j] = Double.parseDouble(st.nextToken());
            }
            sb.append(String.format("%d %f", test , (data[0] * data[3]) / (data[1] + data[2]))).append("\n");
        }
        System.out.print(sb);
    }
}
