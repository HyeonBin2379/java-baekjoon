package bakjoon.bakjoon16XXX;

import java.util.Scanner;

public class Exercise16693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p1 = sc.nextInt();
        int r = sc.nextInt();
        int p2 = sc.nextInt();
        sc.close();

        double pizza1 = (double)a/p1;
        double pizza2 = Math.PI*r*r/p2;
        System.out.println(pizza1 > pizza2 ? "Slice of pizza" : "Whole pizza");
    }
}
