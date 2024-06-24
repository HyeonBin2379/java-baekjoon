package bakjoon.bakjoon7XXX;

import java.util.Scanner;

public class Exercise7595 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            for (int i = 1; i <= num; i++) {
                sb.append("*".repeat(i)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
