package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(br.readLine());
            int foul = Integer.parseInt(br.readLine());
            int total = 5*score-3*foul;
            count += (total > 40) ? 1 : 0;
        }

        System.out.print(count);
        if (count == n) {
            System.out.println("+");
        }
    }
}
