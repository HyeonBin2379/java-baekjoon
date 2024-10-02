package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21866 {

    private static final int[] maxScore = {100, 100, 200, 200, 300, 300, 400, 400, 500};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int j : maxScore) {
            int score = Integer.parseInt(st.nextToken());
            if (score > j) {
                System.out.println("hacker");
                return;
            }
            sum += score;
        }
        System.out.println(sum >= 100 ? "draw" : "none");
    }
}
