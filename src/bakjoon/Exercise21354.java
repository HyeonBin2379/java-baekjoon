package bakjoon;

import java.util.Scanner;

public class Exercise21354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt()*7;
        int p = sc.nextInt()*13;
        if (a > p) {
            System.out.println("Axel");
        } else if (a == p) {
            System.out.println("lika");
        } else {
            System.out.println("Petra");
        }
    }
}
