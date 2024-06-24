package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        int s = sc.nextInt();
        int h = sc.nextInt();

        int len = 3 + 2*s;
        for (int i = 0; i < t; i++) {
            String line = " ".repeat(s) + "*";
            sb.append("*").append(line.repeat(2)).append("\n");
        }
        sb.append("*".repeat(len)).append("\n");

        for (int i = 0; i < h; i++) {
            String line = " ".repeat(s+1) + "*";
            sb.append(line).append("\n");
        }
        System.out.print(sb);
    }
}
