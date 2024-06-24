package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1331 {

    private static final int[][] board = new int[6][6];
    private static final int[][] route = new int[36][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 36; i++) {
            String next = br.readLine();
            int r = next.charAt(0)-'A';
            int c = next.charAt(1)-'0'-1;
            route[i] = new int[]{r, c};
        }
        System.out.println(isValid() ? "Valid" : "Invalid");
    }

    private static boolean isValid() {
        for (int i = 1; i <= 36; i++) {
            int rowMove = Math.abs(route[i % 36][0]-route[i-1][0]);
            int colMove = Math.abs(route[i % 36][1]-route[i-1][1]);
            if ((rowMove == 2 && colMove == 1) || (rowMove == 1 && colMove == 2)) {
                board[route[i-1][0]][route[i-1][1]] += 1;
                if (board[route[i-1][0]][route[i-1][1]] != 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
