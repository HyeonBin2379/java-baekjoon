package bakjoon;

import java.util.Scanner;

public class Exercise31922 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(Math.max(a+c, p));
    }
}
