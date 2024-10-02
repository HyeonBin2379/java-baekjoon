package baekjoon.baekjoon28XXX;

import java.util.Scanner;

public class Exercise28635 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        System.out.println(b >= a ? b-a : (m-a)+b);
        sc.close();
    }
}
