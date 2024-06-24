package bakjoon.bakjoon23XXX;

import java.util.Scanner;

public class Exercise23806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 1; i <= num*5; i++) {
            if (i <= num || i > num*4) {
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
