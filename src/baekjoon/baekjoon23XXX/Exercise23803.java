package baekjoon.baekjoon23XXX;

import java.util.Scanner;

public class Exercise23803 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 1; i <= num*5; i++) {
            if (i <= 4*num) {
                sb.append("@".repeat(num)).append("\n");
            } else {
                sb.append("@".repeat(5*num)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
