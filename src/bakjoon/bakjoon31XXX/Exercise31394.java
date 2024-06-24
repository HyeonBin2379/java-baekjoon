package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31394 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        boolean satisfactory = false;
        boolean excellent = true;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
            if (score[i] == 3) {
                satisfactory = true;
            } else if (score[i] != 5) {
                excellent = false;
            }
            sum += score[i];
        }

        if (satisfactory) {
            System.out.println("None");
        } else if (excellent) {
            System.out.println("Named");
        } else if (Double.compare(sum/n, 4.5) >= 0) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }
    }
}
