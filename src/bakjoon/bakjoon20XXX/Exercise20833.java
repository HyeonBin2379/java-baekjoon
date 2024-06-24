package bakjoon.bakjoon20XXX;

import java.util.Scanner;

public class Exercise20833 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        long sum = 0;
        for (long i = 1; i <= num; i++) {
            sum += Math.pow(i, 3);
        }
        sc.close();
        System.out.println(sum);
    }
}
