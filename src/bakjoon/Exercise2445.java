package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] star = new char[2*N-1][2*N];

        for (int i = 1; i < N; i++) {
            Arrays.fill(star[i-1], '*');
            for (int j = i; j < star[i-1].length/2; j++) {
                star[i-1][j] = star[i-1][star[i-1].length-1-j] = ' ';
            }
        }
        Arrays.fill(star[N-1], '*');
        for (int i = 1; i < N; i++) {
            Arrays.fill(star[N+i-1], '*');
            for (int j = N-i; j < N+i; j++) {
                star[N+i-1][j] = ' ';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : star) {
            sb.append(chars).append("\n");
        }
        System.out.print(sb);
    }
}
