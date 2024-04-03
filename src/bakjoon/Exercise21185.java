package bakjoon;

import java.util.Scanner;

public class Exercise21185 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 4 == 0) {
            System.out.println("Even");
        } else if (num % 4 == 2) {
            System.out.println("Odd");
        } else {
            System.out.println("Either");
        }
    }
}
