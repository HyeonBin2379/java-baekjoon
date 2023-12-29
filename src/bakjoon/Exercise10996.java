package bakjoon;

import java.util.Scanner;

public class Exercise10996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        for (int i = 1; i <= 2*size; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= size; j++) {
                    if (j % 2 == 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            } else {
                for (int j = 1; j <= size; j++) {
                    if (j % 2 == 1) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            sb.append("\n");
        }
        sc.close();
        System.out.print(sb);
    }
}
