package baekjoon.baekjoon23XXX;

import java.util.Scanner;

public class Exercise23809 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 0; i < 5*num; i++) {
            if (i/num == 0 || i/num == 4) {
                sb.append("@".repeat(num))
                        .append(" ".repeat(num*3))
                        .append("@".repeat(num))
                        .append("\n");
            } else if (i/num == 1 || i/num == 3) {
                sb.append("@".repeat(num))
                        .append(" ".repeat(num*2))
                        .append("@".repeat(num))
                        .append("\n");
            } else {
                sb.append("@".repeat(num*3)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
