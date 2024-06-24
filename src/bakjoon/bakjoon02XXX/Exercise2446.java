package bakjoon.bakjoon02XXX;

import java.util.Scanner;

public class Exercise2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(Math.max(0, 2 * (N - i) - 1)));
            sb.append("\n");
        }
        for (int i = 0; i < N-1; i++) {
            sb.append(" ".repeat(Math.max(0, N - 1 - i - 1)));
            sb.append("*".repeat(Math.max(0, 2 * i + 3)));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
