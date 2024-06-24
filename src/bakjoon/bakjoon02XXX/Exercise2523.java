package bakjoon.bakjoon02XXX;

import java.util.Scanner;

public class Exercise2523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int row = sc.nextInt();
        for (int i = 0; i < 2*row-1; i++) {
            if (i < row) {
                sb.append("*".repeat(i + 1)).append("\n");
            } else {
                sb.append("*".repeat(Math.max(0, 2*row-1-i))).append("\n");
            }
        }
        System.out.print(sb);
    }
}
