package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            String[] tokens = input.split(" ");
            StringBuilder target = new StringBuilder(tokens[0]);
            StringBuilder guess = new StringBuilder(tokens[1]);
            int[] color = new int[3];

            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == guess.charAt(i)) {
                    guess.setCharAt(i, '*');
                    target.setCharAt(i, '*');
                    color[0]++;
                }
            }
            if (color[0] == target.length()) {
                sb.append(String.format("%s: %d black, %d grey, %d white\n", tokens[1], color[0], color[1], color[2]));
                continue;
            }

            for (int i = 0; i < target.length(); i++) {
                if (guess.charAt(i) != '*') {
                    if (i > 0 && target.charAt(i - 1) == guess.charAt(i)) {
                        target.setCharAt(i - 1, '*');
                        guess.setCharAt(i, '*');
                        color[1]++;
                    }
                    if (i < target.length() - 1 && target.charAt(i + 1) == guess.charAt(i)) {
                        target.setCharAt(i + 1, '*');
                        guess.setCharAt(i, '*');
                        color[1]++;
                    }
                }
            }
            if (color[0]+color[1] == target.length()) {
                sb.append(String.format("%s: %d black, %d grey, %d white\n", tokens[1], color[0], color[1], color[2]));
                continue;
            }

            for (int i = 0; i < target.length(); i++) {
                String ch = String.valueOf(target.charAt(i));
                if (target.charAt(i) != '*' && guess.toString().contains(ch)) {
                    color[2]++;
                }
            }
            sb.append(String.format("%s: %d black, %d grey, %d white\n", tokens[1], color[0], color[1], color[2]));
        }
        System.out.print(sb);
    }
}
