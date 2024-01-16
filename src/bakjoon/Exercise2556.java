package bakjoon;

import java.util.Scanner;

public class Exercise2556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("*".repeat(size));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
