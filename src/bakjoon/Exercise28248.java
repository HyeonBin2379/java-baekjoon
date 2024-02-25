package bakjoon;

import java.util.Scanner;

public class Exercise28248 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int c = sc.nextInt();
        int score = 50*p - 10*c;
        score += (p > c) ? 500 : 0;
        System.out.println(score);
    }
}
