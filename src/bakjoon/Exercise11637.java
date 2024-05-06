package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] votes = new int[n];
            int max = 0, total = 0;
            int winner = 0;

            for (int j = 0; j < n; j++) {
                votes[j] = Integer.parseInt(br.readLine());
                total += votes[j];
                if (votes[j] > max) {
                    max = votes[j];
                    winner = j+1;
                }
            }
            int finalMax = max;
            int count = (int) Arrays.stream(votes).filter(value -> value == finalMax).count();
            if (count > 1) {
                System.out.println("no winner");
            } else if (max <= total/2) {
                System.out.println("minority winner " + winner);
            } else {
                System.out.println("majority winner " + winner);
            }
        }
    }
}
