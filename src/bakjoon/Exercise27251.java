package bakjoon;

import java.util.Scanner;

public class Exercise27251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            if (i <= 10) {
                sb.append("*".repeat(i * i)).append("\n");
            } else {
                sb.append("*".repeat(100)).append("...\n");
            }
        }
        System.out.print(sb);
    }
}
