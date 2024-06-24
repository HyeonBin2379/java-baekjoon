package bakjoon.bakjoon5XXX;

import java.util.Scanner;

public class Exercise5543 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int top = sc.nextInt();
        int mid = sc.nextInt();
        int bottom = sc.nextInt();
        int coke = sc.nextInt();
        int cider = sc.nextInt();
        sc.close();

        int total = Math.min(Math.min(top, mid), bottom) + Math.min(coke, cider) - 50;
        System.out.println(total);
    }
}
