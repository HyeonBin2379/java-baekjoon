package bakjoon;

import java.util.Scanner;

public class Exercise25628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bread = sc.nextInt();
        int patty = sc.nextInt();
        System.out.println(Math.min(bread/2, patty));
    }
}
