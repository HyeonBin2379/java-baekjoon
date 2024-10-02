package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32306 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] team1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] team2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int score1 = 0, score2 = 0;
        for (int i = 1; i <= 3; i++) {
            score1 += i*team1[i-1];
            score2 += i*team2[i-1];
        }
        if (score1 > score2) {
            System.out.println(1);
        } else if (score1 < score2) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
