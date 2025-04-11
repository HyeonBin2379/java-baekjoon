package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long v = sc.nextInt();

        System.out.println((int) Math.ceil((double)(v-a)/(a-b))+1);
    }
}
