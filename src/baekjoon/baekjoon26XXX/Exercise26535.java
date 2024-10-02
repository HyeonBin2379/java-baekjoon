package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26535 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int hen = sc.nextInt();
        int size = 1;
        while (size*size < hen) {
            size++;
        }

        sb.append("x".repeat(size+2)).append("\n");
        for (int i = 1; i <= size; i++) {
            sb.append("x").append(".".repeat(size)).append("x").append("\n");
        }
        sb.append("x".repeat(size+2)).append("\n");
        System.out.print(sb);
    }
}
