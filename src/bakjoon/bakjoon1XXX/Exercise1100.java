package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> position = new ArrayList<>();
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'F') {
                    position.add(new int[] {i, j});
                }
            }
        }
        int count = 0;
        for (int[] pos : position) {
            if (pos[0] % 2 == 0) {
                count += (pos[1] % 2 == 0) ? 1 : 0;
            } else {
                count += (pos[1] % 2 == 0) ? 0 : 1;
            }
        }
        System.out.println(count);
    }
}
