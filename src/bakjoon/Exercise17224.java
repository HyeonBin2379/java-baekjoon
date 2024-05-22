package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise17224 {

    private static class Difficulty implements Comparable<Difficulty> {
        int easy, hard;

        public Difficulty(int easy, int hard) {
            this.easy = easy;
            this.hard = hard;
        }

        @Override
        public int compareTo(Difficulty o) {
            return (this.hard != o.hard) ? this.hard-o.hard : this.easy - o.easy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Difficulty> problem = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());
            problem.add(new Difficulty(easy, hard));
        }
        List<Difficulty> canSolve = problem.stream()
                .filter(d -> l >= d.easy || l >= d.hard)
                .sorted()
                .limit(k)
                .toList();

        int total = 0;
        for (Difficulty d : canSolve) {
            int score = 0;
            if (d.easy <= l) {
                score = 100;
            }
            if (d.hard <= l) {
                score = 140;
            }
            total += score;
        }

        System.out.println(total);
    }
}
