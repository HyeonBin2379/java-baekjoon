package bakjoon;

import java.util.Scanner;

public class Exercise2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(Math.max(1, 2 * i - 1)));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
