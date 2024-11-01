package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise32504 {

    private static class Score {
        int home, away;

        public Score(int home, int away) {
            this.home = home;
            this.away = away;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Score> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int home = Integer.parseInt(st.nextToken());
            int away = Integer.parseInt(st.nextToken());
            list.add(new Score(home, away));
        }

        for (int i = 1; i < n; i++) {
            Score prev = list.get(i-1);
            Score now = list.get(i);

            if (now.home < prev.home || now.away < prev.away) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
