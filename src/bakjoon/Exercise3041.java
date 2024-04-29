package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3041 {

    private static final String ANSWER = "ABCDEFGHIJKLMNO.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] now = new char[4][4];
        for (int i = 0; i < 4; i++) {
            now[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (now[i][j] != ANSWER.charAt(i*4 + j) && now[i][j] != '.') {
                    int index = ANSWER.indexOf(now[i][j]);
                    int row = index / 4;
                    int col = index % 4;
                    answer += (Math.abs(row-i)+Math.abs(col-j));
                }
            }
        }
        System.out.println(answer);
    }
}
