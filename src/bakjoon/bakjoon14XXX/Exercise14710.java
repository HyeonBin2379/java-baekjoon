package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14710 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hAngle = sc.nextInt();
        int mAngle = sc.nextInt();
        if ((hAngle % 30)*12 == mAngle) {
            System.out.println("O");
        } else {
            System.out.println("X");
        }
    }
}
