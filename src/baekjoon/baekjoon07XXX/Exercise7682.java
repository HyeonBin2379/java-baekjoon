package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise7682 {

    private static char[][] ticTacToe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            ticTacToe = new char[3][3];
            int xCnt = 0, oCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ticTacToe[i][j] = input.charAt(i*3+j);
                    switch (ticTacToe[i][j]) {
                        case 'O' -> oCnt++;
                        case 'X' -> xCnt++;
                    }
                }
            }
            boolean xWin = check('X');
            boolean oWin = check('O');
            if ((xWin && !oWin && xCnt == oCnt+1)
                    || (!xWin && oWin && xCnt == oCnt)
                    || (!xWin && !oWin && xCnt == 5 && oCnt == 4)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean check(char player) {
        for (int i = 0; i < 3; i++) {
            int idx = i;
            if (IntStream.range(0, 3).allMatch(j -> ticTacToe[idx][j] == player)) {
                return true;
            }
            if (IntStream.range(0, 3).allMatch(j -> ticTacToe[j][idx] == player)) {
                return true;
            }
        }
        if (IntStream.range(0, 3).allMatch(j -> ticTacToe[j][j] == player)) {
            return true;
        }
        return IntStream.range(0, 3).allMatch(j -> ticTacToe[j][2 - j] == player);
    }
}
