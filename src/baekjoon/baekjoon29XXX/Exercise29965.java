package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise29965 {

    public static double calculateAverage(List<Integer> scores) {
        if (scores.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> mariScores = new ArrayList<>();
        List<Integer> juriScores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String player = input[0];
            int score = Integer.parseInt(input[1]);
            if (player.equals("M")) {
                mariScores.add(score);
            } else {
                juriScores.add(score);
            }
        }

        double mariAvg = calculateAverage(mariScores);
        double juriAvg = calculateAverage(juriScores);
        if (mariAvg > juriAvg) {
            System.out.println("M");
        } else if (mariAvg < juriAvg) {
            System.out.println("J");
        } else {
            System.out.println("V");
        }
    }
}