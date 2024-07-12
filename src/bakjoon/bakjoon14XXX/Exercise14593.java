package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14593 {
    private static class Info {
        int number;
        int score, count, latest;

        public Info(int number, int score, int count, int latest) {
            this.number = number;
            this.score = score;
            this.count = count;
            this.latest = latest;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] player = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int latest = Integer.parseInt(st.nextToken());
            player[i] = new Info(i+1, score, count, latest);
        }
        Arrays.sort(player, (o1, o2) -> {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else if (o1.count != o2.count) {
                return o1.count-o2.count;
            } else {
                return o1.latest-o2.latest;
            }
        });
        System.out.println(player[0].number);
    }
}
