package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise10994 {
    private static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 4 * sc.nextInt() - 3;
        star = new char[size][size];
        for (char[] chars : star) {
            Arrays.fill(chars, ' ');
        }
        sc.close();

        solution(0, size);

        StringBuilder sb = new StringBuilder();
        for (char[] chars : star) {
            sb.append(chars).append("\n");
        }
        System.out.print(sb);
    }

    public static void solution(int start, int len) {
        if (len <= start) {
            return;
        }

        for (int i = start; i < len; i++) {
            star[start][i] = '*';
            star[i][start] = '*';
            star[i][len-1] = '*';
            star[len-1][i] = '*';
        }

        solution(start+2, len-2);
    }
}
