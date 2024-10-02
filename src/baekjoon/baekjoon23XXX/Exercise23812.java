package baekjoon.baekjoon23XXX;

import java.util.Scanner;

public class Exercise23812 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 0; i < num*5; i++) {
            if (i/num % 2 == 1) {
                sb.append("@".repeat(num*5)).append("\n");
            } else {
                sb.append("@".repeat(num))
                        .append(" ".repeat(num*3))
                        .append("@".repeat(num))
                        .append("\n");
            }
        }
        System.out.print(sb);
    }
}
