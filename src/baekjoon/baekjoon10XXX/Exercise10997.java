package baekjoon.baekjoon10XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise10997 {
    private static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        star = new char[4*size-1][4*size-3];
        for (char[] chars : star) {
            Arrays.fill(chars, ' ');
        }

        if (size == 1) {
            star[0][0] = '*';
        } else {
            pointStars(0, size);
        }

        for (int i = 0; i < star.length; i++) {
            if (i == 1) {
                sb.append(star[i][0]).append("\n");
                continue;
            }
            sb.append(star[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void pointStars(int start, int size) {
        if (size == 1) { // 노란색
            star[start][start] = star[start+1][start] = star[start+2][start] = '*';
            return;
        }

        int row = 4*size-1;
        int col = row-2;
        for (int i = start; i < start+col; i++) { // 연두색
            star[start][i] = star[start+row-1][i] = '*';
        }
        for (int i = start+2; i < start+row-1; i++) { // 파란색
            star[i][start] = star[i][start+col-1] = '*';
        }
        star[start+1][start] = star[start+2][start+col-2] = '*'; // 분홍색
        pointStars(start+2, size-1);
    }
}
