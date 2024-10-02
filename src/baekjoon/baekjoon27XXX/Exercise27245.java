package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27245 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int l = sc.nextInt();
        int h = sc.nextInt();
        if (Math.max(w, l) / Math.min(w, l) <= 2 && Math.min(w, l) / h >= 2) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
