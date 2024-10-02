package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2033 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        int start = 10;
        while (num > start) {
            int digitNum = num % start;
            if (digitNum >= start/2) {
                num += start;
            }
            num -= digitNum;
            start *= 10;
        }
        System.out.println(num);
    }
}
