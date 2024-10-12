package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26360 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int shot = Integer.parseInt(br.readLine());
        int foul = Integer.parseInt(br.readLine());

        int score = 0;
        if (shot == 1) {
            score += x;
        }
        if (foul == 1) {
            int additional;
            switch (shot) {
                case 0 -> {
                    for (int i = 0; i < x; i++) {
                        additional = Integer.parseInt(br.readLine());
                        score += additional;
                    }
                }
                case 1 -> {
                    additional = Integer.parseInt(br.readLine());
                    score += additional;
                }
            }
        }
        System.out.println(score);
    }
}
