package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise29503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] move = br.readLine().toCharArray();
            int fromCol = move[0]-'a';
            int fromRow = 8-(move[1]-'0');

            int toCol = move[2]-'a';
            int toRow = 8-(move[3]-'0');

            sb.append(board[fromRow][fromCol]);

            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = '.';
        }
        System.out.println(sb);
    }
}
