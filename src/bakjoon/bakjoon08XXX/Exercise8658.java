package bakjoon.bakjoon08XXX;

import java.util.Scanner;

public class Exercise8658 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int min = num+1;
        for (int i = 2; i <= num; i++) {
            if (num % i != 0) {
                min = Math.min(i, min);
                break;
            }
        }
        int max = num-1;
        System.out.println(min + " " + max);
    }
}
