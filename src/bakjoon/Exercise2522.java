package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        char[][] star = new char[row*2-1][row];
        for (int i = 0; i < star.length; i++) {
            Arrays.fill(star[i], '*');
            if (i < row-1) {
                for (int j = 0; j < row-1-i; j++) {
                    star[i][j] = ' ';
                }
            } else {
                for (int j = 0; j < i-row+1; j++) {
                    star[i][j] = ' ';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : star) {
            sb.append(chars).append("\n");
        }
        System.out.print(sb);
    }
}
