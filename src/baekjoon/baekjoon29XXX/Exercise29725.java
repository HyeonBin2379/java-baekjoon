package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise29725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> score = new LinkedHashMap<>(Map.of(
                'K', 0,
                'P', 1,
                'N', 3,
                'B', 3,
                'R', 5,
                'Q', 9
        ));
        char[][] board = new char[8][8];
        int white = 0, black = 0;

        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (board[i][j] == Character.toUpperCase(board[i][j])) {
                    white += score.get(Character.toUpperCase(board[i][j]));
                } else {
                    black += score.get(Character.toUpperCase(board[i][j]));
                }
            }
        }
        System.out.println(white - black);
    }
}
