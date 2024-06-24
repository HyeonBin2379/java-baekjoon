package bakjoon.bakjoon20XXX;

import java.util.Scanner;

public class Exercise20215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        double d = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
        System.out.printf("%.9f\n", Math.abs(w+h - d));
    }
}
