package bakjoon;

import java.util.Scanner;

public class Exercise10992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" ".repeat(Math.max(0, size - 1 - i)));
            if (i == 0 || i == size-1) {
                sb.append("*".repeat(2*i + 1));
            } else {
                for (int j = 0; j < 2*i+1; j++) {
                    if (j == 0 || j == 2*i) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
