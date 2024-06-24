package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String team1 = br.readLine();
        String team2 = br.readLine();
        int len = Integer.parseInt(br.readLine());
        String[] record = br.readLine().split("");

        int[] score = new int[2];
        for (int i = 0; i < len; i++) {
            switch (record[i]) {
                case "H" -> score[i % 2] += 1;
                case "D" -> score[i % 2] += 2;
                case "O" -> score[(i + 1) % 2] += 1;
            }
            if (score[0] >= 7 || score[1] >= 7) {
                break;
            }
        }

        System.out.printf("%s %d %s %d. ", team1, Math.min(score[0], 7), team2, Math.min(score[1], 7));
        if (score[0] > score[1]) {
            System.out.println(team1 + (score[0] >= 7 ? " has won." : " is winning."));
        } else if (score[0] < score[1]) {
            System.out.println(team2 + (score[1] >= 7 ? " has won." : " is winning."));
        } else {
            System.out.println("All square.");
        }
    }
}
