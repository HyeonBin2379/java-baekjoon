package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10995 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                sb.append("* ".repeat(size)).append("\n");
            } else {
                sb.append(" *".repeat(size)).append("\n");
            }
        }
        sc.close();
        System.out.print(sb);
    }
}
