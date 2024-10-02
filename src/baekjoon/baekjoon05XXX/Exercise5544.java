package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise5544 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scoreBoard = new int[n];
        for (int i = 1; i <= n*(n-1)/2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamA = Integer.parseInt(st.nextToken())-1;
            int teamB = Integer.parseInt(st.nextToken())-1;
            int scoreA = Integer.parseInt(st.nextToken());
            int scoreB = Integer.parseInt(st.nextToken());

            if (scoreA > scoreB) {
                scoreBoard[teamA] += 3;
            } else if (scoreA == scoreB) {
                scoreBoard[teamA] += 1;
                scoreBoard[teamB] += 1;
            } else {
                scoreBoard[teamB] += 3;
            }
        }

        int[] ranks = IntStream.range(0, n).map(i -> 1).toArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scoreBoard[i] < scoreBoard[j]) {
                    ranks[i]++;
                }
            }
        }
        Arrays.stream(ranks).forEach(System.out::println);
    }
}
