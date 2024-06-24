package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14624 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("I LOVE CBNU");
            return;
        }
        StringBuilder answer = new StringBuilder("*".repeat(n) + "\n");
        for (int i = 1; i <= (n+1)/2; i++) {
            answer.append(" ".repeat((n+1)/2 - i)).append("*");
            if (i == 1) {
                answer.append("\n");
                continue;
            }
            answer.append(" ".repeat(i*2-3)).append("*\n");
        }
        System.out.print(answer);
    }
}
