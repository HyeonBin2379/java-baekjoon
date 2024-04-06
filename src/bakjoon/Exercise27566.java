package bakjoon;

import java.util.Scanner;

public class Exercise27566 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int f = sc.nextInt();

        double rotate = 180 * (double)f/r;
        double vertical = rotate % 360.0;
        if (vertical < 90 || vertical > 270) {
            System.out.println("up");
        } else {
            System.out.println("down");
        }
    }
}
