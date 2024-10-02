package baekjoon.baekjoon14XXX;

import java.util.Scanner;

public class Exercise14568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        int count = 0;
        for (int a = 2; a <= num; a += 2) {
            for (int b = 1; b <= num-2; b++) {
                for (int c = b+2; c <= num; c++) {
                    if (a+b+c == num) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
