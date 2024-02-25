package bakjoon;

import java.util.Scanner;

public class Exercise27855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int player1 = sc.nextInt()*3;
        player1 += sc.nextInt();

        int player2 = sc.nextInt()*3;
        player2 += sc.nextInt();

        if (player1 > player2) {
            System.out.println(1 + " " + (player1-player2));
        } else if (player1 == player2) {
            System.out.println("NO SCORE");
        } else {
            System.out.println(2 + " " + (player2-player1));
        }
    }
}
