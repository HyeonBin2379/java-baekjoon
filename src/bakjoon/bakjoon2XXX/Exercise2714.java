package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2714 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String binary = st.nextToken();

            String[][] input = new String[r][c];
            for (int j = 0; j < r*c; j++) {
                input[j/c][j%c] = String.valueOf(binary.charAt(j));
            }

            StringBuilder decode = new StringBuilder();
            int x = 0, y = 0;
            int move = 1;
            int row = r-1, col = c;

            while (true) {
                for (int j = 0; j < col; j++) {
                    decode.append(input[x][y]);
                    y += move;
                }
                x += move;
                y -= move;
                col--;

                if (decode.length() >= r*c) {
                    break;
                }

                for (int j = 0; j < row; j++) {
                    decode.append(input[x][y]);
                    x += move;
                }
                x -= move;
                y -= move;
                row--;
                move *= -1;
            }

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < decode.length(); j += 5) {
                int num = Integer.parseInt(decode.substring(j, Math.min(j+5, decode.length())), 2);
                answer.append(num != 0 ? (char) ('A' + num-1) : ' ');
            }
            System.out.println(answer.toString().trim());
        }
    }
}
