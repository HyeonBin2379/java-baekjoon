package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise32684 {

    private static final int[] scores = {13, 7, 5, 3, 3, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cho = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] han = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double score1 = IntStream.range(0, scores.length).map(idx -> cho[idx]*scores[idx]).sum();
        double score2 = IntStream.range(0, scores.length).map(idx -> han[idx]*scores[idx]).sum() + 1.5;

        if (score1 > score2) {
            System.out.println("cocjr0208");
        } else {
            System.out.println("ekwoo");
        }
    }
}
