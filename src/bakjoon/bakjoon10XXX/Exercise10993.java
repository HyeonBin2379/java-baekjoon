package bakjoon.bakjoon10XXX;

import static java.lang.Math.pow;
import java.io.IOException;
import java.util.Scanner;

public class Exercise10993 {
    private static final char[][] star = new char[1023][2045];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int row = (int) pow(2, size)-1;
        int col = row*2-1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                star[i][j] = ' ';
            }
        }

        pointStar(size, size, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (star[i][j] == 'x') {
                    break;
                }
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void pointStar(int end, int len, int x, int y) {
        if (len == 0)
            return;
        if (len % 2 == 0) {
            int gap = (int) pow(2, len) - 1;
            for (int i = 0; i < gap; i++) {
                if (i == 0) {
                    for (int j = 0; j < 2 * gap - 1; j++)
                        star[x + i][y + j] = '*';
                }
                else {
                    star[x + i][y + i] = star[x + i][y + (2 * gap - 2 - i)] = '*';
                    if (end == len) star[x + i][y + (2 * gap - 1 - i)] = 'x';
                }
            }
            pointStar(end, len - 1, x + 1, y + (int) pow(2, len - 1));
        }
        else {
            int gap = (int) pow(2, len) - 1;
            for (int i = 0; i < gap; i++) {
                if (i == gap - 1) {
                    for (int j = 0; j < 2 * gap - 1; j++) {
                        star[x + i][y + j] = '*';
                    }
                }
                else {
                    star[x + i][y + (gap - 1 - i)] = star[x + i][y + (gap - 1 + i)] = '*';
                    if (end == len) {
                        star[x + i][y + (gap + i)] = 'x';
                    }
                }
            }
            pointStar(end, len - 1, x + (int)pow(2, len - 1) - 1, y + (int)pow(2, len - 1));
        }
    }
}
