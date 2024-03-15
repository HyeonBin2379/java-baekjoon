package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30395 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int streak = 0, maxStreak = 0;
        int coolTime = 0;
        boolean freeze = true;
        for (int i = 1; i <= n; i++) {
            int solved = Integer.parseInt(st.nextToken());
            if (!freeze) {
                coolTime++;
            }
            if (coolTime == 2) {
                freeze = true;
                coolTime = 0;
            }

            if (solved == 0) {
                if (!freeze) {
                    streak = 0;
                } else {
                    freeze = false;
                }
            } else {
                streak += 1;
            }
            maxStreak = Math.max(streak, maxStreak);
        }
        System.out.println(maxStreak);
    }
}
