package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int count = 1;
        int numBox = 1;
        while (num > numBox) {
            numBox += 6*count;
            count++;
        }
        System.out.println(count);
    }
}
