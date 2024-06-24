package bakjoon.bakjoon2XXX;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2441 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] star = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], '*');
            for (int j = 0; j < i; j++) {
                star[i][j] = ' ';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(star[i]).append("\n");
        }
        System.out.print(sb);
    }
}
