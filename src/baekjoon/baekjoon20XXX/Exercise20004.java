package baekjoon.baekjoon20XXX;

import java.util.Scanner;

public class Exercise20004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            int diff = i+1;
            if (30 % diff == 0) {
                System.out.println(i);
            }
        }
    }
}
