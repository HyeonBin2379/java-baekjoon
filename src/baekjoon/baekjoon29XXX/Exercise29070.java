package baekjoon.baekjoon29XXX;

import java.util.Scanner;

public class Exercise29070 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();
        System.out.println((int)Math.ceil((double)h/a)*(int)Math.ceil((double)w/b));
    }
}
