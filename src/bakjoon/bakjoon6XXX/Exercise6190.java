package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int score = 0;
        while (num != 1) {
            num = (num % 2 == 1) ? num*3+1 : num/2;
            score++;
        }
        sc.close();
        System.out.println(score);
    }
}
