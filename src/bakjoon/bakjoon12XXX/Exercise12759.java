package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12759 {

    private static final int[][] ticTacToe = new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int now = (i % 2 == 0) ? first : (first == 1) ? 2 : 1;

            ticTacToe[r][c] = now;
            if (getAnswer(now) != 0) {
                answer = now;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int getAnswer(int player) {
        for (int i = 0; i < 3; i++) {
            if (Arrays.stream(ticTacToe[i]).allMatch(value -> value == player)) {
                return player;
            }
        }

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                cnt += ticTacToe[j][i] == player ? 1 : 0;
            }
            if (cnt == 3) {
                return player;
            }
        }

        int d1 = 0, d2 = 0;
        for (int i = 0; i < 3; i++) {
            d1 += (ticTacToe[i][i] == player) ? 1 : 0;
            d2 += (ticTacToe[i][2-i] == player) ? 1 : 0;
        }
        if (d1 == 3 || d2 == 3) {
            return player;
        }
        return 0;
    }
}
