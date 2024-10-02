package baekjoon.baekjoon31XXX;

import java.util.Scanner;

public class Exercise31907 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String line = switch (i) {
                case 0 -> ("G".repeat(n) + ".".repeat(3 * n) + "\n");
                case 1 -> (".".repeat(n) + "I".repeat(n) + ".".repeat(n) + "T".repeat(n) + "\n");
                case 2 -> (".".repeat(2 * n) + "S".repeat(n) + ".".repeat(n) + "\n");
                default -> "";
            };
            answer.append(line.repeat(n));
        }
        System.out.print(answer);
    }
}
