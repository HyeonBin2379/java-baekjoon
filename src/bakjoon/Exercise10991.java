package bakjoon;

import java.util.Scanner;

public class Exercise10991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" ".repeat(Math.max(0, size - 1 - i)));
            if (i == 0) {
                sb.append("*");
            } else {
                sb.append("* ".repeat(i + 1));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
