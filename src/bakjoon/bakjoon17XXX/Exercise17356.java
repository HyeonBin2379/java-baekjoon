package bakjoon.bakjoon17XXX;

import java.util.Scanner;

public class Exercise17356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        double m = (b-a) / 400.0;
        System.out.println(1/(1+Math.pow(10, m)));
    }
}
