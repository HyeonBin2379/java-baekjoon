package bakjoon.bakjoon23XXX;

import java.util.Scanner;

public class Exercise23055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] result = new char[n][n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n-1) {
                    result[i][j] = '*';
                } else if (j == 0 || j == n-1) {
                    result[i][j] = '*';
                } else if (i == j || i == n-1-j) {
                    result[i][j] = '*';
                } else {
                    result[i][j] = ' ';
                }
            }
            sb.append(new String(result[i])).append("\n");
        }
        System.out.print(sb);
    }
}
