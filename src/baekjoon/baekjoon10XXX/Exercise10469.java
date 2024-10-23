package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise10469 {

    private static final char[][] board = new char[8][8];
    private static final List<Integer[]> queens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    queens.add(new Integer[]{i, j});
                }
            }
        }

        if (queens.size() != 8) {
            System.out.println("invalid");
            return;
        }
        for (int i = 0; i < queens.size()-1; i++) {
            for (int j = i+1; j < queens.size(); j++) {
                if (canMeet(i, j)) {
                    System.out.println("invalid");
                    return;
                }
            }
        }
        System.out.println("valid");
    }

    private static boolean canMeet(int i, int j) {
        Integer[] queen1 = queens.get(i);
        Integer[] queen2 = queens.get(j);
        return queen1[0].equals(queen2[0])
                || queen1[1].equals(queen2[1])
                || Math.abs(queen1[0]-queen2[0]) == Math.abs(queen1[1]-queen2[1]);
    }
}
