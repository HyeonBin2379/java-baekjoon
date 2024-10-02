package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            double[] pos = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            int n = 0, m = 0;
            for (int j = 0; j < 12; j += 2) {
                double dist = Math.sqrt(Math.pow(pos[j], 2) + Math.pow(pos[j+1], 2));
                if (j < 6) {
                    n += getScore(dist);
                } else {
                    m += getScore(dist);
                }
            }

            sb.append(String.format("SCORE: %d to %d, ", n, m));
            if (n > m) {
                sb.append("PLAYER 1 WINS.\n");
            } else if (n == m) {
                sb.append("TIE.\n");
            } else {
                sb.append("PLAYER 2 WINS.\n");
            }
        }
        System.out.print(sb);
    }

    public static int getScore(double dist) {
        for (int i = 1; i <= 5; i++) {
            if (Double.compare(dist, 3.0*i) <= 0) {
                return 120-20*i;
            }
        }
        return 0;
    }
}
