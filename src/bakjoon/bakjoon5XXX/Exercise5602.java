package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise5602 {

    private static class Spot implements Comparable<Spot> {
        int score, num;

        public Spot(int score, int num) {
            this.score = score;
            this.num = num;
        }

        @Override
        public int compareTo(Spot o) {
            if (score != o.score) {
                return o.score - score;
            } else {
                return num - o.num;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] check = new int[c][r];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                check[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Spot[] result = new Spot[c];
        for (int i = 1; i <= c; i++) {
            int sum = Arrays.stream(check[i-1]).sum();
            result[i-1] = new Spot(sum, i);
        }
        System.out.println(Arrays.stream(result)
                .sorted()
                .map(spot -> Integer.toString(spot.num))
                .collect(Collectors.joining(" ")));
    }
}
