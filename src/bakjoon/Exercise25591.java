package bakjoon;

import java.util.Scanner;

public class Exercise25591 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();

        int a = 100-num1;
        int b = 100-num2;
        int c = 100-(a+b);
        int d = a*b;
        System.out.print(a + " " + b + " " + c + " " + d + " ");
        System.out.println((d/100) + " " + (d % 100));
        System.out.println((c + d/100) + " " + (d % 100));
    }
}
