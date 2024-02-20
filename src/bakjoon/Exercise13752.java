package bakjoon;

import java.util.Scanner;

public class Exercise13752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            sb.append("=".repeat(sc.nextInt())).append("\n");
        }
        sc.close();
        System.out.print(sb);
    }
}
