package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextInt();
        System.out.printf("%.10f\n", 100/x);
        System.out.printf("%.10f\n", 100/(100-x));
    }
}
