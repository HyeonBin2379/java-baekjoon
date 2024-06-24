package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int mid = sc.nextInt();
        sc.close();
        System.out.println(mid*2-min);
    }
}
