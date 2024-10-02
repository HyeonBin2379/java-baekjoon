package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(Math.max(0, 2 * (N - i) - 1)));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
