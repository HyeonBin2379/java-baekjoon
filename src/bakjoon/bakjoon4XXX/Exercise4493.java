package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int game = Integer.parseInt(br.readLine());

        for (int i = 0; i < game; i++) {
            int[] player = new int[2];
            int round = Integer.parseInt(br.readLine());
            for (int j = 0; j < round; j++) {
                Character[] hand = Arrays.stream(br.readLine().split(" ")).map(s -> s.charAt(0)).toArray(Character[]::new);
                if (hand[0] == hand[1]) {
                    continue;
                }

                if ((hand[0] == 'R' && hand[1] == 'S')
                        || (hand[0] == 'S' && hand[1] == 'P')
                        || (hand[0] == 'P' && hand[1] == 'R')) {
                    player[0]++;
                } else {
                    player[1]++;
                }
            }

            if (player[0] > player[1]) {
                sb.append("Player 1\n");
            } else if (player[0] == player[1]) {
                sb.append("TIE\n");
            } else {
                sb.append("Player 2\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
