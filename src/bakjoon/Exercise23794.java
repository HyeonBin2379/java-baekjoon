package bakjoon;

import java.util.Scanner;

public class Exercise23794 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        for (int i = 1; i <= num+2; i++) {
            if (i == 1 || i == num+2) {
                sb.append("@".repeat(num+2)).append("\n");
            } else {
                sb.append("@").append(" ".repeat(num)).append("@").append("\n");
            }
        }
        System.out.print(sb);
    }
}
