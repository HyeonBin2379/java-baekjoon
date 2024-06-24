package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6763 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int speed = sc.nextInt();
        int diff = speed - limit;
        sc.close();

        if (diff <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (diff <= 20) {
            System.out.printf("You are speeding and your fine is $%d.\n", 100);
        } else if (diff <= 30) {
            System.out.printf("You are speeding and your fine is $%d.\n", 270);
        } else {
            System.out.printf("You are speeding and your fine is $%d.\n", 500);
        }
    }
}
