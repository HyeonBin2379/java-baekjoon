package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[100001];
        for (int i = 0; i < n; i++) {
            double score = Double.parseDouble(br.readLine());
            scores[(int)(score*1000)]++;
        }

        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == 0) {
                continue;
            }
            if (count > 7) {
                break;
            }
            while (scores[i]-- > 0 && count++ < 7) {
                System.out.printf("%.3f\n", i/1000.0);
            }
        }
    }
}
